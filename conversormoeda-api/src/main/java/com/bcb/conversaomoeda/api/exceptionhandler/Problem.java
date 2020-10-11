/*
 * Representa o corpo do erro de uma exceção seguindo 
 * o formato definido na especificação RFC 7807 (Problems Details for HTTP APIs)
*/
package com.bcb.conversaomoeda.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;

@JsonInclude(Include.NON_NULL)
@Getter
@Builder
public class Problem {
		
	/**
	 * Esses atributos de problema são definido com base na especificação
	 * Problem Details for HTTP APIs
	 */
	private Integer status;
	private String type;
	private String title;
	private String detail;
	
	private String userMessage;
//	private OffsetDateTime timestamp;
	private LocalDateTime timestamp;
	private List<Object> objects;
	
	@Getter
	@Builder
	public static class Object {
		private String name;
		private String userMessage;
	}
}
