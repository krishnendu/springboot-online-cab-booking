package com.kris.demo2.demo2.model;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String userName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private boolean active;
    private String roles;

//    @Column(name = "date_joined", columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime dateJoined;

//    @Column(name = "last_login", columnDefinition = "TIMESTAMP" )
    @UpdateTimestamp
    private LocalDateTime lastLogin;

    private String email;
    private String phoneNumber;
    private String address;

    @OneToOne(targetEntity = Passenger.class ,cascade = CascadeType.ALL)
    @JoinColumn(name = "passenger_uuid", referencedColumnName = "uuid")
    private Passenger passenger;

    @OneToOne(targetEntity = Driver.class ,cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_uuid", referencedColumnName = "uuid")
    private Driver driver;

    public AuthUser() {
        this.active=true;
        this.roles="ROLE_USER";
        this.email="";
        this.address="";
        this.phoneNumber="";
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public LocalDateTime getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDateTime dateJoined) {
        this.dateJoined = dateJoined;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
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

}
