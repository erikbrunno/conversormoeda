package com.bcb.conversaomoeda.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcb.conversaomoeda.api.model.MoedaModel;
import com.bcb.conversaomoeda.domain.model.Moeda;

@Component
public class MoedaModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public MoedaModel toModel(Moeda moeda) {
		return modelMapper.map(moeda, MoedaModel.class);
	}

	public List<MoedaModel> toCollectionModel(List<Moeda> moedas) {
		return moedas.stream().map(moeda -> toModel(moeda)).collect(Collectors.toList());
	}

}
