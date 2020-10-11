package com.bcb.conversaomoeda.api.model;

import java.io.IOException;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

class ParseDeserializerToLocalDateTime extends StdDeserializer<LocalDateTime> {

	public ParseDeserializerToLocalDateTime() {
		super(LocalDateTime.class);
	}

	@Override
	public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		return LocalDateTime.parse(p.getValueAsString().replace(" ", "T"));
	}
}