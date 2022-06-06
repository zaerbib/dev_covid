package com.covid.dev.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "covid_hosp_ad_age")
@Data
public class CovidHospAdAge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adAge_generator")
	private Long id;
	private Integer reg;
	@Column(name = "Semaine")
	private String semaine;
	@Column(name = "cl_age90")
	private Integer clage90;
	@Column(name = "NewAdmHospit")
	private String newAdmHospit;
}
