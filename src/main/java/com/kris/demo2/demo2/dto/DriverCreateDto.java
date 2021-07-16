package com.kris.demo2.demo2.dto;

import com.kris.demo2.demo2.model.AuthUser;
import com.kris.demo2.demo2.model.Cab;
import com.kris.demo2.demo2.model.Driver;
import com.kris.demo2.demo2.model.Location;

public class DriverCreateDto {
    private String name;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;
    private String cabName;
    private String cabModelNumber;
    private Integer cabTotalSeats;
    private double lat;
    private double lng;

    public DriverCreateDto() {
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

    public String getCabName() {
        return cabName;
    }

    public void setCabName(String cabName) {
        this.cabName = cabName;
    }

    public String getCabModelNumber() {
        return cabModelNumber;
    }

    public void setCabModelNumber(String cabModelNumber) {
        this.cabModelNumber = cabModelNumber;
    }

    public Integer getCabTotalSeats() {
        return cabTotalSeats;
    }

    public void setCabTotalSeats(Integer cabTotalSeats) {
        this.cabTotalSeats = cabTotalSeats;
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
        Driver driver = new Driver();
        Cab cab = new Cab();
        cab.setName(cabName);
        cab.setModelNumber(cabModelNumber);
        cab.setTotalSeats(cabTotalSeats);
        driver.setName(name);
        driver.setCab(cab);
        driver.setLocation(new Location(lat,lng));
        user.setDriver(driver);
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);
        return user;
    }
}
