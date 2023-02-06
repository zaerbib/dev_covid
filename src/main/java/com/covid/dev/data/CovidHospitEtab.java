package com.covid.dev.data;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

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

	@Column(insertable = true, name = "updateTime")
	private LocalDateTime updateTime;

	@PrePersist
	public void onCreate() {
		this.setUpdateTime(LocalDateTime.now());
	}
}
