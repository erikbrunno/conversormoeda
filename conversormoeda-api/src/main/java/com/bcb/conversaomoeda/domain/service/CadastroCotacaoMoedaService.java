package com.bcb.conversaomoeda.domain.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcb.conversaomoeda.api.model.CotacaoMoedaBcbModel;
import com.bcb.conversaomoeda.domain.model.CotacaoMoeda;
import com.bcb.conversaomoeda.domain.model.Moeda;
import com.bcb.conversaomoeda.domain.repository.CotacaoMoedaRepository;

@Service
public class CadastroCotacaoMoedaService {

	@Autowired
	private CadastroMoedaService cadastroMoeda;

	@Autowired
	private ConsultarCotacaoMoedaBcbService consultarCotacaoMoedaBcb;

	@Autowired
	private CotacaoMoedaRepository cotacaoMoedaRepository;

	@Transactional
	public CotacaoMoeda salvar(CotacaoMoeda cotacaoMoeda) {

		Moeda moedaOrigem = cadastroMoeda.buscar(cotacaoMoeda.getMoedaOrigem().getId());
		Moeda moedaDestino = cadastroMoeda.buscar(cotacaoMoeda.getMoedaDestino().getId());

		BigDecimal valorConvertido = calcularValorMoeda(cotacaoMoeda, moedaOrigem, moedaDestino);

		cotacaoMoeda.setMoedaOrigem(moedaOrigem);
		cotacaoMoeda.setMoedaDestino(moedaDestino);
		cotacaoMoeda.setValorDestino(valorConvertido);

		return cotacaoMoedaRepository.save(cotacaoMoeda);
	}

	private BigDecimal calcularValorMoeda(CotacaoMoeda cotacaoMoeda, Moeda moedaOrigem, Moeda moedaDestino) {
		CotacaoMoedaBcbModel cotacaoMoedaBcbModelOrigem = consultarCotacaoMoedaBcb
				.consultarUltimaCotacao(moedaOrigem.getSimbolo(), cotacaoMoeda.getDataCadastro());
		CotacaoMoedaBcbModel cotacaoMoedaBcbModelDestino = consultarCotacaoMoedaBcb
				.consultarUltimaCotacao(moedaDestino.getSimbolo(), cotacaoMoeda.getDataCadastro());

		BigDecimal valorConvertido = cotacaoMoedaBcbModelOrigem.getCotacaoVenda().multiply(cotacaoMoeda.getValorOrigem())
				.divide(cotacaoMoedaBcbModelDestino.getCotacaoVenda(), RoundingMode.HALF_UP);
		return valorConvertido;
	}
}
