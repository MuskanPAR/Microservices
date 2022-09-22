package com.microservices.vaccinationcenter.controller;

import com.microservices.vaccinationcenter.entity.VaccinationCenter;
import com.microservices.vaccinationcenter.repository.VaccinationCenterRepo;
import com.microservices.vaccinationcenter.responsemodal.Citizen;
import com.microservices.vaccinationcenter.responsemodal.Response;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/vaccinationCenter")
public class VaccinationController {

    private static final String VACCINATION_CENTER="vaccinationCenter";
    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    VaccinationCenterRepo vaccinationCenterRepo;

    @PostMapping(path = "/registerVaccinationCenter")
    public ResponseEntity<VaccinationCenter> addVaccinationCenter(@RequestBody VaccinationCenter vaccinationCenter) {
        System.out.println("Adding vaccination center");
        vaccinationCenterRepo.save(vaccinationCenter);
        return new ResponseEntity<>(vaccinationCenter, HttpStatus.OK);
    }

    @GetMapping(path = "/vaccinationCenterId/{vaccinationCenterId}")
    @HystrixCommand(fallbackMethod = "handleClientServiceDown")       //hystrix command not preferred
//    @CircuitBreaker(name = VACCINATION_CENTER, fallbackMethod = "handleClientServiceDown")      //resilience4J
    public ResponseEntity<Response> getDataOnCenterId(@PathVariable int vaccinationCenterId) {

        System.out.println("Running instance "+instanceId);
        Response response=new Response();

        //get vaccinationCenter Detail using vaccinationCenterId
        VaccinationCenter vaccinationCenter=vaccinationCenterRepo.findById(vaccinationCenterId).get();
        response.setVaccinationCenter(vaccinationCenter);

        //then get list of citizens registered
        int centerId=vaccinationCenter.getVaccinationCenterId();
        System.out.println(centerId);

        //call citizen service for getting list of citizens corresponding to vaccinationCenterId.
        List<Citizen> citizenList= restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+centerId, List.class);

        response.setCitizens(citizenList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    public ResponseEntity<Response> handleClientServiceDown(@PathVariable int vaccinationCenterId) {

        try {
            System.out.println("Running instance "+instanceId);
            //when client service is down, then it will not fetch clientDetails, but just fetch vaccination center details based on center id provided.
            Response response=new Response();

            //get vaccinationCenter Detail using vaccinationCenterId
            VaccinationCenter vaccinationCenter=vaccinationCenterRepo.findById(vaccinationCenterId).get();
            response.setVaccinationCenter(vaccinationCenter);

            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
