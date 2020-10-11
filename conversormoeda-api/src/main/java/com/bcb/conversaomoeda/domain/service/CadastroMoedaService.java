package com.bcb.conversaomoeda.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcb.conversaomoeda.domain.exception.MoedaNaoEncontradaException;
import com.bcb.conversaomoeda.domain.model.Moeda;
import com.bcb.conversaomoeda.domain.repository.MoedaRepository;

@Service
public class CadastroMoedaService {

	@Autowired
	private MoedaRepository moedaRepository;

	@Autowired
	private CadastroMoedaBcService cadastroMoedaBcService;

	public List<Moeda> consultar() {
		/*
		 * Importa as moedas disponíveis do servico externo no bcb para nossa base de
		 * dados, apenas se ela nao estiver cadastrada
		 */
		cadastroMoedaBcService.importacaoMoeda();

		return moedaRepository.findAll();
	}

	public Moeda buscar(Long moedaId) {
		return moedaRepository.findById(moedaId).orElseThrow(() -> new MoedaNaoEncontradaException(moedaId));
	}
}
