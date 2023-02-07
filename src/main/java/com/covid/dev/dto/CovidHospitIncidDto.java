package com.covid.dev.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CovidHospitIncidDto {
	private Integer dep;
	private Date jour;
	private Integer incidHosp;
	private Integer incidRea;
	private Integer incidDc;
	private Integer incidRad;
}
