package com.example.chess.domain;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class SquareSerializer extends JsonSerializer<Square> {

    @Override
    public void serialize(Square square, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String fieldName = square.getColumn().name() + square.getRow().getValue();
        jsonGenerator.writeFieldName(fieldName);
    }
}
