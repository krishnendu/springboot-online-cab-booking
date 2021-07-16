package com.kris.demo2.demo2.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Location {

    private double lat;

    private double lng;

    public Location() {
    }
//    public Location(String json) throws JsonProcessingException {
//        Location location=new ObjectMapper().readerFor(Location.class).readValue(json);
//        this.longitude=location.getLongitude();
//        this.latitude=location.getLatitude();
//    }


    public Location(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(this);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return "Location{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }
}
