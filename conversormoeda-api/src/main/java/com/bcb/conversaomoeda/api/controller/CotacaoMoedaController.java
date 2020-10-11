package com.bcb.conversaomoeda.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bcb.conversaomoeda.api.assembler.CotacaoMoedaInputDisassembler;
import com.bcb.conversaomoeda.api.assembler.CotacaoMoedaModelAssembler;
import com.bcb.conversaomoeda.api.model.CotacaoMoedaModel;
import com.bcb.conversaomoeda.api.model.input.CotacaoMoedaInput;
import com.bcb.conversaomoeda.domain.exception.CotacaoMoedaBcbNaoEncontradaException;
import com.bcb.conversaomoeda.domain.exception.MoedaNaoEncontradaException;
import com.bcb.conversaomoeda.domain.exception.NegocioException;
import com.bcb.conversaomoeda.domain.model.CotacaoMoeda;
import com.bcb.conversaomoeda.domain.repository.CotacaoMoedaRepository;
import com.bcb.conversaomoeda.domain.service.CadastroCotacaoMoedaService;

@RestController
@RequestMapping("/cotacao-moeda")
public class CotacaoMoedaController {

	@Autowired
	private CotacaoMoedaInputDisassembler cotacaoMoedaInputDisassembler;
	
	@Autowired
	private CadastroCotacaoMoedaService cadastroCotacaoMoeda;

	@Autowired
	private CotacaoMoedaModelAssembler cotacaoMoedaModelAssembler;
	
	@Autowired
	private CotacaoMoedaRepository cotacaoMoedaRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CotacaoMoedaModel adicionar(@RequestBody @Valid CotacaoMoedaInput cotacaoMoedaInput) {
		
		CotacaoMoeda cotacaoMoeda = cotacaoMoedaInputDisassembler.toDomainObject(cotacaoMoedaInput);
		
		try {
			cotacaoMoeda = cadastroCotacaoMoeda.salvar(cotacaoMoeda);
			return cotacaoMoedaModelAssembler.toModel(cotacaoMoeda);
		} catch (MoedaNaoEncontradaException | CotacaoMoedaBcbNaoEncontradaException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}     
	
	@GetMapping
	public List<CotacaoMoedaModel> listar() {
		List<CotacaoMoeda> todasCotacoes = cotacaoMoedaRepository.findAll();
		return cotacaoMoedaModelAssembler.toCollectionModel(todasCotacoes);
	}
}
