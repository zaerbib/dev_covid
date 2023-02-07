package com.covid.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.dev.data.CovidHospitIncidReg;

@Repository
public interface CovidHospitIncidRegDao extends JpaRepository<CovidHospitIncidReg, Long> {

}
