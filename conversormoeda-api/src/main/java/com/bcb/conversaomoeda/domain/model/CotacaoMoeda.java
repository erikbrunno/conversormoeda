package com.bcb.conversaomoeda.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cotacao")
public class CotacaoMoeda {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Moeda moedaOrigem;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Moeda moedaDestino;
	
	@Column(nullable = false, columnDefinition = "datetime")
	private LocalDate dataCadastro;
	
	@Column(nullable = false)
	private BigDecimal valorOrigem;
	
	@Column(nullable = false)
	private BigDecimal valorDestino;
	
}
