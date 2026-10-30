package br.com.erudio.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;


import java.io.IOException;


public class SerializeGenero extends ValueSerializer<String> {


    @Override
    public void serialize(String value, tools.jackson.core.JsonGenerator gen, SerializationContext ctxt) throws JacksonException {
        String formatGender = "Male".equals(value) ? "M" : "F";
        gen.writeString(formatGender);

    }
}
