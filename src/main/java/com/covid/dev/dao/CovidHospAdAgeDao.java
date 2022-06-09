package com.covid.dev.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.dev.data.CovidHospAdAge;

@Repository
public interface CovidHospAdAgeDao extends JpaRepository<CovidHospAdAge, Long> {

}