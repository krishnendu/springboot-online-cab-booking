package com.kris.demo2.demo2.restcontroller;

import com.kris.demo2.demo2.model.Cab;
import com.kris.demo2.demo2.repo.CabRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cab")
public class CabRestController {

    final CabRepository cabRepository;

    public CabRestController(CabRepository cabRepository) {
        this.cabRepository = cabRepository;
    }

    @GetMapping("/all")
    private List<Cab> getAllCabs(){
//        List<Cab> cabs = new ArrayList<Cab>();
//        cabRepository.findAll().forEach(cab1 -> cabs.add(cab1));
        return cabRepository.findAll();
    }
}
