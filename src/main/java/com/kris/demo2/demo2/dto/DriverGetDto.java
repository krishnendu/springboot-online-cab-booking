package com.kris.demo2.demo2.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kris.demo2.demo2.model.Location;

public class DriverGetDto {
    private String name;
    private String userName;
    private String phoneNumber;
    private Location location;
    private String cabModelNumber;
    private int cabTotalSeats;
    private double distanceFromUser;

    public DriverGetDto() {
    }

    public DriverGetDto(String name, String userName, String phoneNumber, Location location, String cabModelNumber, int cabTotalSeats, double distanceFromUser) {
        this.name = name;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.cabModelNumber = cabModelNumber;
        this.cabTotalSeats = cabTotalSeats;
        this.distanceFromUser = distanceFromUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getCabModelNumber() {
        return cabModelNumber;
    }

    public void setCabModelNumber(String cabModelNumber) {
        this.cabModelNumber = cabModelNumber;
    }

    public int getCabTotalSeats() {
        return cabTotalSeats;
    }

    public void setCabTotalSeats(int cabTotalSeats) {
        this.cabTotalSeats = cabTotalSeats;
    }

    public double getDistanceFromUser() {
        return distanceFromUser;
    }

    public void setDistanceFromUser(double distanceFromUser) {
        this.distanceFromUser = distanceFromUser;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "DriverGetDto{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", location=" + location +
                ", cabModelNumber='" + cabModelNumber + '\'' +
                ", cabTotalSeats=" + cabTotalSeats +
                '}';
    }
}
