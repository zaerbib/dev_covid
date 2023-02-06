package com.covid.dev.data;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "covid_hospit_clage10")
@Data
public class CovidHospitClage10 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clage10")
	private Long id;
	private Integer reg;
	@Column(name = "cl_age90")
	private Integer clage90;
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

	@Column(insertable = true, name = "updateTime")
	private LocalDateTime updateTime;

	@PrePersist
	public void onCreate(){
		this.setUpdateTime(LocalDateTime.now());
	}
	
}
