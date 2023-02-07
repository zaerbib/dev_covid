package com.covid.dev.service;

import com.covid.dev.repository.CovidHospitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CovidHospitService {

    private final CovidHospitRepository covidHospitRepository;

    public CovidHospitService(CovidHospitRepository covidHospitRepository) {
        this.covidHospitRepository = covidHospitRepository;
    }
}
