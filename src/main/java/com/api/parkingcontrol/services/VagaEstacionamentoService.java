package com.api.parkingcontrol.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.dto.VagaEstacionamentoDto;
import com.api.parkingcontrol.models.VagaEstacionamentoModel;
import com.api.parkingcontrol.repository.VagaEstacionamentoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class VagaEstacionamentoService {

	@Autowired
	VagaEstacionamentoRepository vagaEstacionamentoRepository;

	@Transactional
	public VagaEstacionamentoModel salva(VagaEstacionamentoModel vagaEstacionalemtoModel) {
				
		return vagaEstacionamentoRepository.save(vagaEstacionalemtoModel);
	}

	public Page<VagaEstacionamentoModel> listaTodos(Pageable pageable) {

		return vagaEstacionamentoRepository.findAll(pageable);
	}

	public boolean verificaPlaca(String placaVeiculo) {
	
		Optional<VagaEstacionamentoModel> placaEstacionamento = vagaEstacionamentoRepository.findByPlacaVeiculo(placaVeiculo);
		
		if(placaEstacionamento.isPresent()) {
			
			return true;
		}
		
		return false;
	}

	public boolean verificaVaga(String numeroVaga) {
		
		Optional<VagaEstacionamentoModel> numVaga = vagaEstacionamentoRepository.findByNumeroVaga(numeroVaga);
		
		if(numVaga.isPresent()) {
			return true;
		}
		
		
		return false;
	}

	public Optional<VagaEstacionamentoModel> listaVagaEstacionamentoPorID(UUID id) {
		
		return vagaEstacionamentoRepository.findById(id);
	}

	public void delete(UUID id) {
		vagaEstacionamentoRepository.deleteById(id);
		
	}

		
}
