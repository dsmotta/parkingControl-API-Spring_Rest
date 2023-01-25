package com.api.parkingcontrol.controllers;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.swing.SortOrder;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.dto.VagaEstacionamentoDto;
import com.api.parkingcontrol.models.VagaEstacionamentoModel;
import com.api.parkingcontrol.services.VagaEstacionamentoService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vaga-estacionamento")
public class VagaEstacionamentoController {
	
	@Autowired
	VagaEstacionamentoService vagaEstacionamentoService;
	
	@PostMapping
	public ResponseEntity<Object> salvaVagaEstacionamento(@Valid @RequestBody VagaEstacionamentoDto vagaEstacionamentoDto){
		
		if(vagaEstacionamentoService.verificaPlaca(vagaEstacionamentoDto.getPlacaVeiculo())) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Placa do veículo já cadastrada!");
		}
		
		if(vagaEstacionamentoService.verificaVaga(vagaEstacionamentoDto.getNumeroVaga())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Vaga de estacionamento em uso!");
		}
		
				
		
		var vagaEstacionalemtoModel = new VagaEstacionamentoModel();
		
		BeanUtils.copyProperties(vagaEstacionamentoDto, vagaEstacionalemtoModel);
		vagaEstacionalemtoModel.setDataRegistro(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
		return ResponseEntity.status(HttpStatus.CREATED).body(vagaEstacionamentoService.salva(vagaEstacionalemtoModel));
	}
	
	@GetMapping
	public ResponseEntity<Page<VagaEstacionamentoModel>> listaTodasVagasEstacionamento(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) org.springframework.data.domain.Pageable pageable){
		
		return ResponseEntity.status(HttpStatus.OK).body(vagaEstacionamentoService.listaTodos(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> verificaVagaEstacionamentoPorID(@PathVariable(value = "id") UUID id){
		
		Optional<VagaEstacionamentoModel> vagaEstacionamento = vagaEstacionamentoService.listaVagaEstacionamentoPorID(id);
		
		if(!vagaEstacionamento.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga de Estacionamento não encontrada !");
		}
		return ResponseEntity.status(HttpStatus.OK).body(vagaEstacionamento.get());
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletaVagaEstacionamentoPorID(@PathVariable(value = "id") UUID id){
		
		Optional<VagaEstacionamentoModel> vagaEstacionamento = vagaEstacionamentoService.listaVagaEstacionamentoPorID(id);
		if(!vagaEstacionamento.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga de Estacionamento não encontrada !");
		}
		
		vagaEstacionamentoService.delete(vagaEstacionamento.get().getId());
		
		return ResponseEntity.status(HttpStatus.OK).body("Vaga Estacionamento deletada com suscesso!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizaVagaEstacionamento(@PathVariable(value = "id") UUID id, @Valid @RequestBody VagaEstacionamentoDto vagaEstacionamentoDto){
		
		Optional<VagaEstacionamentoModel> vagaEstacionamento = vagaEstacionamentoService.listaVagaEstacionamentoPorID(id);
		
		if(!vagaEstacionamento.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga de Estacionamento não encontrada !");
		}
		
		var vagaAtualizada = new VagaEstacionamentoModel();
		BeanUtils.copyProperties(vagaEstacionamentoDto, vagaAtualizada);
		vagaAtualizada.setId(vagaEstacionamento.get().getId());
		vagaAtualizada.setDataRegistro(vagaEstacionamento.get().getDataRegistro());
		
		return ResponseEntity.status(HttpStatus.OK).body(vagaEstacionamentoService.salva(vagaAtualizada));
	}
	
	
		

}
