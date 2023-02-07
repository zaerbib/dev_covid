package com.covid.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covid.dev.data.CovidHospitEtab;

public interface CovidHospitEtabDao extends JpaRepository<CovidHospitEtab, Long> {

}
