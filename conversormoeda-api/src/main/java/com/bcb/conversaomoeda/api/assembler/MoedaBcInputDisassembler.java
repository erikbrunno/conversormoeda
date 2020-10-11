package com.bcb.conversaomoeda.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcb.conversaomoeda.api.model.MoedaBcbModel;
import com.bcb.conversaomoeda.domain.model.Moeda;

@Component
public class MoedaBcInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Moeda toDomainObject(MoedaBcbModel moedaBcbInput) {
		return modelMapper.map(moedaBcbInput, Moeda.class);
	}

}
