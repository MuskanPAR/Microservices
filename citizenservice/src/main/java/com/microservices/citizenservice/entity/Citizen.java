package com.microservices.citizenservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String vaccinationCenterId;

    public Citizen() {
    }

    public Citizen(Long id, String name, String vaccinationCenterId) {
        this.id = id;
        this.name = name;
        this.vaccinationCenterId = vaccinationCenterId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVaccinationCenterId() {
        return vaccinationCenterId;
    }

    public void setVaccinationCenterId(String vaccinationCenterId) {
        this.vaccinationCenterId = vaccinationCenterId;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vaccinationCenterId='" + vaccinationCenterId + '\'' +
                '}';
    }
}
