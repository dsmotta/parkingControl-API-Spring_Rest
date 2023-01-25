package com.api.parkingcontrol.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.parkingcontrol.models.VagaEstacionamentoModel;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface VagaEstacionamentoRepository extends JpaRepository<VagaEstacionamentoModel, UUID>{

	Optional<VagaEstacionamentoModel> findByPlacaVeiculo(String placaVeiculo);
	
	Optional<VagaEstacionamentoModel> findByNumeroVaga(String numeroVaga);
		
}