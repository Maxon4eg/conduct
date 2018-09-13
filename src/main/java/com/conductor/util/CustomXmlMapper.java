package com.conductor.util;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;

public class CustomXmlMapper implements ObjectMapper {
    @Override
    public Object deserialize(ObjectMapperDeserializationContext context) {
        XmlMapper mapper = new XmlMapper();
        try {
            return mapper.readValue(context.getDataToDeserialize().asInputStream(), context.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object serialize(ObjectMapperSerializationContext context) {
        throw new NotImplementedException();
    }
}
