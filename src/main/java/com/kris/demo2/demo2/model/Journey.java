package com.kris.demo2.demo2.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.kris.demo2.demo2.converter.LocationJsonConverter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="uuid")
public class Journey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

//    @Column(name = "start_date_time", columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime startDateTime;

//    @Column(name = "end_date_time", columnDefinition = "TIMESTAMP" )
//    @UpdateTimestamp
    private LocalDateTime endDateTime;

    @ManyToOne
    @JoinColumn(name="passenger_uuid")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name="driver_uuid")
    private Driver driver;

    private Double cost;

    private Double distance;

    @Convert(converter = LocationJsonConverter.class)
    private Location origin;

    @Convert(converter = LocationJsonConverter.class)
    private Location destination;

    private  boolean started;

    private boolean completed;

    public Journey() {

        this.startDateTime=LocalDateTime.now();
        this.completed=false;
        this.started=false;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Location getOrigin() {
        return origin;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.startDateTime=LocalDateTime.now();
        this.started = started;
        this.getDriver().getCab().setActive(true);
        this.getDriver().setLocation(this.destination);
        this.getPassenger().setLocation(this.destination);
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed=completed;
    }

    public void setCompleted() {
        this.completed = true;
        this.endDateTime=LocalDateTime.now();
        this.cost=11*this.distance;
        this.getDriver().getCab().setActive(false);
    }
}
