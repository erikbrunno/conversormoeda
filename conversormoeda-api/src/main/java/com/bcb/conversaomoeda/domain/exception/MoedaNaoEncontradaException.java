package com.bcb.conversaomoeda.domain.exception;

public class MoedaNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	private static final String MSG_MOEDA_NAO_ENCONTRADA = "Não existe um cadastro de moeda com o código %d";;
	
	public MoedaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public MoedaNaoEncontradaException(Long cozinhaId) {
		this(String.format(MSG_MOEDA_NAO_ENCONTRADA, cozinhaId));
	}
}
