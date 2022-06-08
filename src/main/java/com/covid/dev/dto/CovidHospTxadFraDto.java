package com.covid.dev.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CovidHospTxadFraDto {
	private String fra;
	private Integer strate2;
	private Date jour;
	private Integer pourAvec;
	private Double txIndic7JDc;
	private Double txIndic7JHosp;
	private Double txIndic7JSc;
	private Double txPrevHosp;
	private Double txPrevSc;
}
