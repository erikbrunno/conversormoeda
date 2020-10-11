package com.bcb.conversaomoeda.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CotacaoMoedaModel {

	private Long id;
	
	private MoedaModel moedaOrigem;
	
	private MoedaModel moedaDestino;
	
	private LocalDate dataCadastro;
	
	private BigDecimal valorOrigem;
	
	private BigDecimal valorDestino;
	
}
