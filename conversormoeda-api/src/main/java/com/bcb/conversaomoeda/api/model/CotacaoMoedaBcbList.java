package com.bcb.conversaomoeda.api.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CotacaoMoedaBcbList {
	
	@JsonProperty("value")
	private List<CotacaoMoedaBcbModel> cotacoes = new ArrayList<CotacaoMoedaBcbModel>();
}
