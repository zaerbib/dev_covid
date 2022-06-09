package com.covid.dev.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.dev.data.CovidHospitIncid;

@Repository
public interface CovidHospitIncidDao extends JpaRepository<CovidHospitIncid, Long> {

}
