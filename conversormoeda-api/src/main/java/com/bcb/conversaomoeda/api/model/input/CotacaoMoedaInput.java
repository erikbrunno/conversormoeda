package com.bcb.conversaomoeda.api.model.input;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.bcb.conversaomoeda.api.model.ParseDeserializerToLocalDate;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CotacaoMoedaInput {
	
	@Valid
	@NotNull
	private MoedaIdInput moedaOrigem;
	
	@Valid
	@NotNull
	private MoedaIdInput moedaDestino;

	@NotNull
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonDeserialize(using = ParseDeserializerToLocalDate.class)
	private LocalDate dataConsulta;
	
	@NotNull
	private BigDecimal valorOrigem;
	
}
