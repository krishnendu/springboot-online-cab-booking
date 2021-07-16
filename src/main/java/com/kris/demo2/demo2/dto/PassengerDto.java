package com.kris.demo2.demo2.dto;

import com.kris.demo2.demo2.model.AuthUser;
import com.kris.demo2.demo2.model.Location;
import com.kris.demo2.demo2.model.Passenger;

public class PassengerDto {
    private String name;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;
    private double lat;
    private double lng;

    public PassengerDto() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public AuthUser getUser(){
        AuthUser user = new AuthUser();
        Passenger passenger = new Passenger();
        passenger.setName(name);
        passenger.setLocation(new Location(lat,lng));
        user.setPassenger(passenger);
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);
        return user;
    }

    @Override
    public String toString() {
        return "PassengerDto{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
