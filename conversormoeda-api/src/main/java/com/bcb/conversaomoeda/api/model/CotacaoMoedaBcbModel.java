package com.bcb.conversaomoeda.api.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CotacaoMoedaBcbModel {

	private BigDecimal cotacaoVenda;

	@JsonSerialize(using = ToStringSerializer.class)
	@JsonDeserialize(using = ParseDeserializerToLocalDateTime.class)
	private LocalDateTime dataHoraCotacao;
	
	private String tipoBoletim;
}
