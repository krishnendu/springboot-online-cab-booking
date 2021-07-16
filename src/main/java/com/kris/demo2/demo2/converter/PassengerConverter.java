//package com.kris.demo2.demo2.converter;
//
//import com.kris.demo2.demo2.dto.PassengerDto;
//import com.kris.demo2.demo2.model.AuthUser;
//import com.kris.demo2.demo2.model.Passenger;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class PassengerConverter {
//
//    AuthUser dtoToEntity(PassengerDto passengerDto){
//        Passenger passenger = new Passenger();
//        AuthUser user = new AuthUser();
//        passenger.setName(passengerDto.getName());
//        return user;
//    }
//
//    PassengerDto entityToDto(Passenger passenger){
//        PassengerDto passengerDto = new PassengerDto();
//        passengerDto.setName(passenger.getName());
//        return passengerDto;
//    }
//
//    List<Passenger> dtoToEntity(List<PassengerDto> passengerDtos){
//        return passengerDtos.stream().map(this::dtoToEntity).collect(Collectors.toList());
//    }
//
//    List<PassengerDto> entityToDto(List<Passenger> passengers){
//        return passengers.stream().map(this::entityToDto).collect(Collectors.toList());
//    }
//}
