package com.bcb.conversaomoeda.amqp.message;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProblemaMensagem {

	@JsonProperty("codigo_http")
	private Integer codigoHttp;
	
	@JsonProperty("tipo")
	private String tipo;
	
	@JsonProperty("titulo")
	private String titulo;
	
	@JsonProperty("detalhe")
	private String detalhe;
	
	@JsonProperty("mensagem_usuario")
	private String mensagemUsuario;
	
	@JsonProperty("timestamp")
	private String timestamp;
	
	@JsonProperty("stacktrace")
	private String stacktrace;
}
