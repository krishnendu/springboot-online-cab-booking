package com.kris.demo2.demo2.dto;

import com.kris.demo2.demo2.model.Location;

public class UpdateLocationWithUserName {
    private String userName;
    private Location location;

    public UpdateLocationWithUserName() {
    }

    public UpdateLocationWithUserName(String userName, Location location) {
        this.userName = userName;
        this.location = location;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "UpdateLocationWithUserName{" +
                "userName='" + userName + '\'' +
                ", location=" + location +
                '}';
    }
}
