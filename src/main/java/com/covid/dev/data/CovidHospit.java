package com.covid.dev.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "covid_hospit")
@Data
public class CovidHospit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hospit_generator")
	private Long id;
	private String dep;
	private Character sex;
	private Date jour;
	private Integer hosp;
	private Integer rea;
	@Column(name = "HospConv")
	private Integer hospConv;
	@Column(name = "SSR_USLD")
	private Integer ssrUsld;
	private Integer autres;
	private Integer rad;
	private Integer dc;
}
