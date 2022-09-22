package com.microservices.citizenservice.controller;

import com.microservices.citizenservice.entity.Citizen;
import com.microservices.citizenservice.repository.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @Autowired
    CitizenRepo citizenRepo;

    @RequestMapping("/test")
    public String hello() {
        return "hello";
    }

    @GetMapping(path = "/id/{vaccinationCenterId}")
    public ResponseEntity<List<Citizen>> getCitizens(@PathVariable String vaccinationCenterId) {
        List<Citizen> citizenList=citizenRepo.findCitizensByVaccinationCenterId(vaccinationCenterId);
        System.out.println("Running on instance "+instanceId);
        return new ResponseEntity<>(citizenList,HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen) {
        System.out.println("Inside add citizen");
        citizenRepo.save(citizen);
        System.out.println(citizen.getId());
        return new ResponseEntity<>(citizen,HttpStatus.OK);
    }


}
