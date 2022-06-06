package com.covid.dev.data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "covid_hosp_etab")
@Data
public class CovidHospitEtab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etab_generator")
	private Long id;
	private Date jour; 
	private Integer nb;
}
