package com.bcb.conversaomoeda.domain.repository;

import org.springframework.stereotype.Repository;

import com.bcb.conversaomoeda.domain.model.CotacaoMoeda;

@Repository
public interface CotacaoMoedaRepository extends CustomJpaRepository<CotacaoMoeda, Long>{
	
}
