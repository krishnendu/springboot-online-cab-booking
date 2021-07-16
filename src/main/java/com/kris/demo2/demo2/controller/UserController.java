package com.kris.demo2.demo2.controller;

import com.kris.demo2.demo2.dto.DriverGetDto;
import com.kris.demo2.demo2.model.AuthUser;
import com.kris.demo2.demo2.model.Driver;
import com.kris.demo2.demo2.model.Location;
import com.kris.demo2.demo2.model.Passenger;
import com.kris.demo2.demo2.repo.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    private String dashboard(Principal principal, ModelMap model){
        AuthUser user1 = userRepository.findByUserName(principal.getName()).get();
        user1.setLastLogin(LocalDateTime.now());
        userRepository.save(user1);
        if(user1.getDriver()==null){
            Passenger passenger = user1.getPassenger();
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
            model.addAttribute("drivers", sortedDrivers);
            model.addAttribute("location", user1.getPassenger().getLocation());
            return "/passenger-dashboard.jsp";
        }
        else
            return "/driver-dashboard.jsp";
    }

    @PutMapping("/")
    private RedirectView putLocation(Principal principal, @RequestParam(name = "lat") Double lat,@RequestParam(name = "lng") Double lng){
        System.out.println(lat+":"+lng);
        AuthUser user = userRepository.findByUserName(principal.getName()).get();
        if(user.getDriver()==null){
            user.getPassenger().setLocation(new Location(lat,lng));
            userRepository.save(user);
        }
        else{
            user.getDriver().setLocation(new Location(lat,lng));
            userRepository.save(user);
        }
        return new RedirectView("/");
    }

    @GetMapping("/1")
    @ResponseBody
    private String demo(Principal principal){
        System.out.println(principal.getName());
        return principal.getName();
    }

    @GetMapping("/2")
    @ResponseBody
    private String currentUserNameSimple(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return principal.getName();
    }
}
