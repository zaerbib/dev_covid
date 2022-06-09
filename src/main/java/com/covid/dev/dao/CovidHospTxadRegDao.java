package com.covid.dev.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.dev.data.CovidHospTxadReg;

@Repository
public interface CovidHospTxadRegDao extends JpaRepository<CovidHospTxadReg, Long> {}
