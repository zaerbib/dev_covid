package com.covid.dev.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covid.dev.data.CovidHospitEtab;

public interface CovidHospitEtabDao extends JpaRepository<CovidHospitEtab, Long> {

}
