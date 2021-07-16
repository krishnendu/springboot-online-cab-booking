package com.kris.demo2.demo2.restcontroller;


import com.kris.demo2.demo2.dto.DriverGetDto;
import com.kris.demo2.demo2.dto.LocationDto;
import com.kris.demo2.demo2.model.AuthUser;
import com.kris.demo2.demo2.model.Driver;
import com.kris.demo2.demo2.model.Location;
import com.kris.demo2.demo2.model.Passenger;
import com.kris.demo2.demo2.repo.PassengerRepository;
import com.kris.demo2.demo2.repo.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.kris.demo2.demo2.converter.LocationDtoConverter.*;

@CrossOrigin
@RestController
@RequestMapping("/api/passenger")
public class PassengerRestController {

    final PassengerRepository passengerRepository;
    final UserRepository userRepository;

    public PassengerRestController(PassengerRepository passengerRepository, UserRepository userRepository) {
        this.passengerRepository = passengerRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    private List<AuthUser> getAllPassengers(){
        return passengerRepository.findAllByUserIsNotNull().stream()
                .map(Passenger::getUser).collect(Collectors.toList());
    }


    @GetMapping("/{userName}")
    private AuthUser getPassengers(@PathVariable("userName") String userName){
        Passenger passenger = passengerRepository.findByUserUserName(userName).orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        return passenger.getUser();
    }

    @PostMapping("/create")
    private UUID create(@RequestBody Passenger passenger){
        System.out.println(passenger.toString());
        return passenger.getUuid();
    }

    @PutMapping("/{userName}/location")
    private String updateLocation(@PathVariable("userName") String userName,@RequestBody LocationDto locationDto){
//        System.out.println(obj.toString());
        try {
            Passenger passenger = passengerRepository.findByUserUserName(userName).orElseThrow(() -> new UsernameNotFoundException("Username Not found!!! "));
            passenger.setLocation(locationToEntity(locationDto));
            passengerRepository.save(passenger);
            return passenger.getUser().getId().toString();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "Error";
    }


    @GetMapping("/{userName}/location")
    private LocationDto getLocationByUserName(@PathVariable("userName") String userName){
        try {
            Passenger passenger = passengerRepository.findByUserUserName(userName).orElseThrow(() -> new UsernameNotFoundException("Username Not found!!! "));
            return entityToLocation(passenger.getLocation());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new LocationDto(0,0);
    }

    @GetMapping ("/{userName}/getdrivers")
    private List<DriverGetDto> getDriversNearby(@PathVariable("userName") String userName){
        Passenger passenger = passengerRepository.findByUserUserName(userName).orElseThrow(() -> new UsernameNotFoundException("Username Not found!!! "));
        List<AuthUser> users = userRepository.findAllByDriverIsNotNullAndDriverCabActiveIsFalse();
        Location origin=passenger.getLocation();
        List<DriverGetDto> sortedDrivers = new ArrayList<>();
        for (AuthUser user : users) {
            double lon1,lon2,lat1,lat2,distance;
            Location destination = user.getDriver().getLocation();
            lon1 = Math.toRadians(origin.getLng());
            lon2 = Math.toRadians(destination.getLng());
            lat1 = Math.toRadians(origin.getLat());
            lat2 = Math.toRadians(destination.getLat());

            // Haversine formula
            double dlon = lon2 - lon1;
            double dlat = lat2 - lat1;
            double a = Math.pow(Math.sin(dlat / 2), 2)
                    + Math.cos(lat1) * Math.cos(lat2)
                    * Math.pow(Math.sin(dlon / 2),2);
            double c = 2 * Math.asin(Math.sqrt(a));
            double r = 6371;// Radius of earth in kilometers. Use 3956 for miles
            distance=c * r;// calculate the result
//            System.out.println(user.getUserName()+"distance = "+distance);
            if(distance<=30){
                Driver driver =user.getDriver();
                sortedDrivers.add(new DriverGetDto(driver.getName(),user.getUserName(),user.getPhoneNumber(), driver.getLocation(), driver.getCab().getModelNumber(),driver.getCab().getTotalSeats(),distance));
            }
        }
        return sortedDrivers;
    }
}
