package com.bcb.conversaomoeda.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcb.conversaomoeda.api.model.CotacaoMoedaModel;
import com.bcb.conversaomoeda.domain.model.CotacaoMoeda;

@Component
public class CotacaoMoedaModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public CotacaoMoedaModel toModel(CotacaoMoeda cotacaoMoeda) {
		return modelMapper.map(cotacaoMoeda, CotacaoMoedaModel.class);
	}

	public List<CotacaoMoedaModel> toCollectionModel(List<CotacaoMoeda> cotacoes) {
		return cotacoes.stream().map(cotacaoMoeda -> toModel(cotacaoMoeda)).collect(Collectors.toList());
	}

}
