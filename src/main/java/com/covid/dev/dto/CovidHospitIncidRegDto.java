package com.covid.dev.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CovidHospitIncidRegDto {
	private Date jour;
	private String nomReg;
	private Integer numReg;
	private String incidRea;
}
