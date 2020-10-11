package com.bcb.conversaomoeda.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcb.conversaomoeda.api.model.input.CotacaoMoedaInput;
import com.bcb.conversaomoeda.domain.model.CotacaoMoeda;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		var modelMapper =  new ModelMapper();
		
		modelMapper.createTypeMap(CotacaoMoedaInput.class, CotacaoMoeda.class).addMapping(CotacaoMoedaInput::getDataConsulta,
				CotacaoMoeda::setDataCadastro);
		
		return modelMapper;
	}

}
