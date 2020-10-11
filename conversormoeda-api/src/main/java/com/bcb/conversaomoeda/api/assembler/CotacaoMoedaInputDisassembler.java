package com.bcb.conversaomoeda.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcb.conversaomoeda.api.model.input.CotacaoMoedaInput;
import com.bcb.conversaomoeda.domain.model.CotacaoMoeda;

@Component
public class CotacaoMoedaInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public CotacaoMoeda toDomainObject(CotacaoMoedaInput cotacaoMoedaInput) {
		return modelMapper.map(cotacaoMoedaInput, CotacaoMoeda.class);
	}

	public void copyToDomainObject(CotacaoMoedaInput cotacaoMoedaInput, CotacaoMoeda cotacaoMoeda) {
		modelMapper.map(cotacaoMoedaInput, cotacaoMoeda);
	}

}
