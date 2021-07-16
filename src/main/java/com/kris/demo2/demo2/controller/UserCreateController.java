package com.kris.demo2.demo2.controller;

import com.kris.demo2.demo2.dto.DriverCreateDto;
import com.kris.demo2.demo2.dto.PassengerDto;
import com.kris.demo2.demo2.model.AuthUser;
import com.kris.demo2.demo2.repo.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/create")
public class UserCreateController {

    final UserRepository userRepository;

    public UserCreateController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/passenger")
    public String createPassengerPage(){
        return "/passenger-register.jsp";
    }

    @PostMapping("/passenger")
    private RedirectView createPassenger(PassengerDto driverDto){
        if(userRepository.findByUserName(driverDto.getUserName()).isEmpty()) {
            AuthUser user = driverDto.getUser();
            userRepository.save(user);
            return new RedirectView("/login");
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Registration Failed!!!");
    }

    @GetMapping("/driver")
    public String createDriverPage(){
        return "/driver-register.jsp";
    }

    @PostMapping("/driver")
    private RedirectView createDriver(DriverCreateDto driverDto){
        if(userRepository.findByUserName(driverDto.getUserName()).isEmpty()) {
            AuthUser user = driverDto.getUser();
            userRepository.save(user);
            return new RedirectView("/login");
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Registration Failed!!!");
    }


}
