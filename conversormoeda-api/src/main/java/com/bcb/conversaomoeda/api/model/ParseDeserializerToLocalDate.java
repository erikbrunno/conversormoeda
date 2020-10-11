package com.bcb.conversaomoeda.api.model;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class ParseDeserializerToLocalDate extends StdDeserializer<LocalDate> {

	public ParseDeserializerToLocalDate() {
		super(LocalDate.class);
	}

	@Override
	public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		return LocalDate.parse(p.getValueAsString().substring(0, 10));
	}
}