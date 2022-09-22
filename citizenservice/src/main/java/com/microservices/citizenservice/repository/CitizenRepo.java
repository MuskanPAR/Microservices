package com.microservices.citizenservice.repository;

import com.microservices.citizenservice.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Long> {
    List<Citizen> findCitizensByVaccinationCenterId(String id);
}
