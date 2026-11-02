package br.com.erudio.serialize;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;


public class SerializeGenero extends ValueSerializer<String> {


    @Override
    public void serialize(String value, tools.jackson.core.JsonGenerator gen, SerializationContext ctxt) throws JacksonException {
        String formatGender = "Male".equals(value) ? "M" : "F";
        gen.writeString(formatGender);

    }
}
