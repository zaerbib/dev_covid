package com.covid.dev.data;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "covid_hospit_incid")
@Data
public class CovidHospitIncid {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "incid_generator")
	private Long id;
	private String dep;
	private Date jour;
	
	@Column(name = "incid_hosp")
	private Integer incidHosp;
	@Column(name = "incide_rea")
	private Integer incidRea;
	@Column(name = "incid_dc")
	private Integer incidDc;
	@Column(name = "incid_rad")
	private Integer incidRad;
	@Column(insertable = true, name = "updateTime")
	private LocalDateTime updateTime;

	@PrePersist
	public void onCreate(){
		this.setUpdateTime(LocalDateTime.now());
	}
}
