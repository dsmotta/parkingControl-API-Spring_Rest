package com.api.parkingcontrol.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// classe criada para controlar os dados enviados pelo usuario ou cliente
// os campos id e dataRegistro nao fazem parte pois serao setados via codigo ou regra de negocio
public class VagaEstacionamentoDto {

	@NotBlank
	private String numeroVaga;
	
	@NotBlank
	@Size(max = 7)
	private String placaVeiculo;
	
	@NotBlank
	private String marcaVeiculo;
	
	@NotBlank
	private String modeloVeiculo;
	
	@NotBlank
	private String corVeiculo;
	
	@NotBlank
	private String nomeResponsavel;
	
	@NotBlank
	private String numeroApartamento;
	
	@NotBlank	
	private String blocoApartamento;
	
	

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
