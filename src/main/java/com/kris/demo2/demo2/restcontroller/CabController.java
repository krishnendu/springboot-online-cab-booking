package com.kris.demo2.demo2.restcontroller;

import com.kris.demo2.demo2.model.Cab;
import com.kris.demo2.demo2.repo.CabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CabController {

    final
    CabRepository cabRepository;

    public CabController(CabRepository cabRepository) {
        this.cabRepository = cabRepository;
    }

    @GetMapping("/home")
    public String home(){
        return "home.jsp";
    }

//    @GetMapping("/create/")
//    public String createPassengerPage(){
//        return "passenger-register.jsp";
//    }

    @GetMapping("/addCab")
    public String addCab(Cab cab)
    {
        cabRepository.save(cab);
        return "home.jsp";
    }

}
