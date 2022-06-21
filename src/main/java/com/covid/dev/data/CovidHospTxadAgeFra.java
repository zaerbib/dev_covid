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
@Table(name = "covid_hosp_txad_age_fra")
@Data
public class CovidHospTxadAgeFra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ageFra_generator")
	private Long id;
	private String fra;	
	private Date jour;
	
	@Column(name = "clage_90")
	private Integer clage90;
	@Column(name = "PourAvec")
	private Integer pourAvec;
	@Column(name = "tx_indic_7J_DC")
	private Double txIndic7JDc;
	@Column(name = "tx_indic_7J_hosp")
	private Double txIndic7JHosp;
	@Column(name = "tx_indic_7J_SC")
	private Double txIndic7JSc;
	@Column(name = "tx_prev_hosp")
	private Double txPrevHosp;
	@Column(name = "tx_prev_SC")
	private Double txPrevSc;
	
}
