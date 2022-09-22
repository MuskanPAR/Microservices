package com.microservices.vaccinationcenter.responsemodal;

import com.microservices.vaccinationcenter.entity.VaccinationCenter;

import java.util.List;

public class Response {

    private VaccinationCenter vaccinationCenter;
    private List<Citizen> citizens;

    public Response() {
    }


    public Response(VaccinationCenter vaccinationCenter, List<Citizen> citizens) {
        this.vaccinationCenter = vaccinationCenter;
        this.citizens = citizens;
    }

    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }

    @Override
    public String toString() {
        return "Response{" +
                "vaccinationCenter=" + vaccinationCenter +
                ", citizens=" + citizens +
                '}';
    }
}
