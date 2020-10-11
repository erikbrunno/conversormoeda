package com.bcb.conversaomoeda.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class MoedaModel {
	
	private Long id;
	private String simbolo;
	private String nomeFormatado;
}