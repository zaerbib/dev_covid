package com.covid.dev.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CovidHospitEtabDto {
	private Integer dep;
	private Date jour; 
	private Integer nb;
}
