package com.api.parkingcontrol.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_vaga_estacionamento")
public class VagaEstacionamentoModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false, unique = true, length = 10)
	private String numeroVaga;
	
	@Column(nullable = false, unique = true, length = 7)
	private String placaVeiculo;
	
	@Column(nullable = true, length = 70)
	private String marcaVeiculo;
	
	@Column(nullable = true, length = 70)
	private String modeloVeiculo;
	
	@Column(nullable = true, length = 70)
	private String corVeiculo;
	
	@Column(nullable = false)
	private LocalDateTime dataRegistro;
	
	@Column(nullable = false, length = 130)
	private String nomeResponsavel;
	
	@Column(nullable = false, length = 30)
	private String numeroApartamento;
	
	@Column(nullable = false, length = 30)
	private String blocoApartamento;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNumeroVaga() {
		return numeroVaga;
	}

	public void setNumeroVaga(String numeroVaga) {
		this.numeroVaga = numeroVaga;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public String getMarcaVeiculo() {
		return marcaVeiculo;
	}

	public void setMarcaVeiculo(String marcaVeiculo) {
		this.marcaVeiculo = marcaVeiculo;
	}

	public String getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}

	public String getCorVeiculo() {
		return corVeiculo;
	}

	public void setCorVeiculo(String corVeiculo) {
		this.corVeiculo = corVeiculo;
	}

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getNumeroApartamento() {
		return numeroApartamento;
	}

	public void setNumeroApartamento(String numeroApartamento) {
		this.numeroApartamento = numeroApartamento;
	}

	public String getBlocoApartamento() {
		return blocoApartamento;
	}

	public void setBlocoApartamento(String blocoApartamento) {
		this.blocoApartamento = blocoApartamento;
	}
	
	
	
	
	
	
	
		

}
