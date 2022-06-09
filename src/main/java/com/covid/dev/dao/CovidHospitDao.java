package com.covid.dev.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.dev.data.CovidHospit;

@Repository
public interface CovidHospitDao extends JpaRepository<CovidHospit, Long> {

}
