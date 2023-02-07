package com.covid.dev.service;

import com.covid.dev.repository.CovidHospitDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CovidHospitService {

    private final CovidHospitDao covidHospitDao;

    public CovidHospitService(CovidHospitDao covidHospitDao) {
        this.covidHospitDao = covidHospitDao;
    }
}
