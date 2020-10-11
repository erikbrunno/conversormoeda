package com.bcb.conversaomoeda.domain.service;

import static com.bcb.conversaomoeda.api.util.Constantes.PATH;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.bcb.conversaomoeda.api.assembler.MoedaBcInputDisassembler;
import com.bcb.conversaomoeda.api.model.MoedaBcbList;
import com.bcb.conversaomoeda.domain.model.Moeda;
import com.bcb.conversaomoeda.domain.repository.MoedaRepository;

@Service
public class CadastroMoedaBcService {

	private static final String URL_BCB_CONSULTAR_MOEDAS = PATH
			+ "Moedas?$top=100&$skip=0&$format=json&$select=simbolo,nomeFormatado";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private MoedaRepository moedaRepository;
	
	@Autowired
	private MoedaBcInputDisassembler moedaBcInputDisassembler;
	
	@Transactional
	public void importacaoMoeda() {
		MoedaBcbList resposta = restTemplate.getForObject(URL_BCB_CONSULTAR_MOEDAS, MoedaBcbList.class);
		
		resposta.getMoedas().stream().forEach(moedaBc -> {
			Optional<Moeda> moedaEncontrada = moedaRepository.findBySimbolo(moedaBc.getSimbolo());
			if (!moedaEncontrada.isPresent()) {
				Moeda moeda = moedaBcInputDisassembler.toDomainObject(moedaBc);
				
				moedaRepository.save(moeda);
			}
		});
	}

}
