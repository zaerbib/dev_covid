package com.covid.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.dev.data.CovidHospTxadAgeFra;

@Repository
public interface CovidHospTxadAgeFraDao extends  JpaRepository<CovidHospTxadAgeFra, Long> {}
