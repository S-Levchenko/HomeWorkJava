package com.pb.levchenko.hw11;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateDeserializer extends StdDeserializer<LocalDateTime> {
    private static final long SerialVersionUID= 1L;
    protected LocalDateDeserializer(){
        super(LocalDate.class);
    }
    @Override
    public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        return LocalDateTime.parse(jp.readValueAs(String.class));
    }
}
