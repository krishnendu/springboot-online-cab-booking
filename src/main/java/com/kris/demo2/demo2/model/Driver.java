package com.kris.demo2.demo2.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.kris.demo2.demo2.converter.LocationJsonConverter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="uuid")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String name;

    @OneToOne(mappedBy = "driver")
    private AuthUser user;

    @OneToOne(targetEntity = Cab.class ,cascade = CascadeType.ALL)
    @JoinColumn(name = "cab_uuid", referencedColumnName = "uuid")
    private Cab cab;

    @Convert(converter = LocationJsonConverter.class)
    private Location location;

    @OneToMany(mappedBy = "driver")
    private List<Journey> journeyList = new ArrayList<>();


    public Driver() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthUser getUser() {
        return user;
    }

    public void setUser(AuthUser user) {
        this.user = user;
    }

    public Cab getCab() {
        return cab;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public List<Journey> getJourneyList() {
        return journeyList;
    }

    public void setJourneyList(List<Journey> journeyList) {
        this.journeyList = journeyList;
    }
}
