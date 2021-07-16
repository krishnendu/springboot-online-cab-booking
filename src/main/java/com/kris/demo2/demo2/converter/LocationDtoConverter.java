package com.kris.demo2.demo2.converter;

import com.kris.demo2.demo2.dto.LocationDto;
import com.kris.demo2.demo2.model.Location;

public class LocationDtoConverter {

    public static Location locationToEntity(LocationDto locationDto){
        Location location = new Location();
        location.setLat(locationDto.getLat());
        location.setLng(locationDto.getLng());
        return location;
    }

    public static LocationDto entityToLocation(Location location){
        LocationDto locationDto = new LocationDto();
        locationDto.setLat(location.getLat());
        locationDto.setLng(location.getLng());
        return locationDto;
    }
}
