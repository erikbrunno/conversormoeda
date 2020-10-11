package com.bcb.conversaomoeda.domain.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.bcb.conversaomoeda.domain.model.Moeda;

@Repository
public interface MoedaRepository extends CustomJpaRepository<Moeda, Long>{
	
	Optional<Moeda> findBySimbolo(String simbolo);
	
}
