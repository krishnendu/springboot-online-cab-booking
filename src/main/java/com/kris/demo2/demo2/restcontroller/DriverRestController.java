package com.kris.demo2.demo2.restcontroller;


import com.kris.demo2.demo2.dto.LocationDto;
import com.kris.demo2.demo2.model.AuthUser;
import com.kris.demo2.demo2.model.Driver;
import com.kris.demo2.demo2.repo.DriverRepository;
import com.kris.demo2.demo2.repo.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static com.kris.demo2.demo2.converter.LocationDtoConverter.entityToLocation;
import static com.kris.demo2.demo2.converter.LocationDtoConverter.locationToEntity;

@CrossOrigin
@RestController
@RequestMapping("/api/driver")
public class DriverRestController {


    final UserRepository userRepository;
    final DriverRepository driverRepository;

    public DriverRestController(DriverRepository driverRepository, UserRepository userRepository) {
        this.driverRepository = driverRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    private List<AuthUser> getAllDrivers(){
        return driverRepository.findAllByUserIsNotNull().stream()
                .map(Driver::getUser).collect(Collectors.toList());
    }

    @GetMapping("/{userName}")
    private AuthUser getDriversByUsername(@PathVariable("userName") String userName){
        Driver driver = driverRepository.findByUserUserName(userName).orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        return driver.getUser();
    }

    @PostMapping("/create")
    private long createDriver(@RequestBody AuthUser user){
//        System.out.println(driver.toString());
        if(userRepository.findByUserName(user.getUserName()).isEmpty()){
            userRepository.save(user);
            return user.getId();
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already Exists!!!");
    }


    @GetMapping("/{userName}/location")
    private LocationDto getLocationByUserName(@PathVariable("userName") String userName){
        Driver driver = driverRepository.findByUserUserName(userName).orElseThrow(() -> new UsernameNotFoundException("Username Not found!!! "));
        return entityToLocation(driver.getLocation());
    }

    @PutMapping("/{userName}/location")
    private boolean putLocationByUserName(@PathVariable("userName") String userName,@RequestBody LocationDto locationDto){
        Driver driver = driverRepository.findByUserUserName(userName).orElseThrow(() -> new UsernameNotFoundException("Username Not found!!! "));
        driver.setLocation(locationToEntity(locationDto));
        driverRepository.save(driver);
        return true;
    }
}
