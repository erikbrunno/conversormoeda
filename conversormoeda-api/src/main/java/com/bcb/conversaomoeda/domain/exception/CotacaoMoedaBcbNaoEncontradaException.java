package com.bcb.conversaomoeda.domain.exception;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CotacaoMoedaBcbNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	private static final String MSG_COTACAO_MOEDA_NAO_ENCONTRADA = "Não foi possível consultar a cotação para data %s";;

	public CotacaoMoedaBcbNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public CotacaoMoedaBcbNaoEncontradaException(LocalDate dataConsulta) {
		this(String.format(MSG_COTACAO_MOEDA_NAO_ENCONTRADA,
				dataConsulta.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
	}
}
