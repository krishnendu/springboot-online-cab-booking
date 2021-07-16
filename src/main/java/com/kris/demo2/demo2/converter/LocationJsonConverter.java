package com.kris.demo2.demo2.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kris.demo2.demo2.model.Location;

import javax.persistence.AttributeConverter;

public class LocationJsonConverter implements AttributeConverter<Location,String> {

    @Override
    public String convertToDatabaseColumn(Location location) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(location);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Location convertToEntityAttribute(String json) {
        try {
            return new ObjectMapper().readerFor(Location.class).readValue(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
