package com.covid.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.dev.data.CovidHospTxadFra;

@Repository
public interface CovidHospTxadFraDao extends JpaRepository<CovidHospTxadFra, Long> {

}
