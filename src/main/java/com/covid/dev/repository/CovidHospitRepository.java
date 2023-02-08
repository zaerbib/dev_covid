package com.covid.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.covid.dev.data.CovidHospit;

import java.util.List;

@Repository
public interface CovidHospitRepository extends JpaRepository<CovidHospit, Long> {
    @Query(value = "select * from covid_hospit che where date_part('Year', che.jour) :=annee", nativeQuery = true)
    public List<CovidHospit> findCovidHospitByAnne(String annee);

    @Query(value = "select * froom covid_hospit " +
            "che where date_part('Year', che.jour):=annee and date_part('month', che.jour) :=mois", nativeQuery = true)
    public List<CovidHospit> findCovidHospitByAnneAndMois(String annee, String mois);

    @Query(value = "select * from covid_hospit che " +
            "where date_part('Year', che.jour) :=annee  and date_part('month', che.jour) :=mois " +
            "and che.dep :=dep", nativeQuery = true)
    public List<CovidHospit> findCovidHospitByAnneeAndMoisAndDep(String annee, String mois, String dep);

}
