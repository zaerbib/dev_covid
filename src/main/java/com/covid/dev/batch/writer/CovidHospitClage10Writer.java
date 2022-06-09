package com.covid.dev.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.covid.dev.dao.CovidHospitClage10Dao;
import com.covid.dev.data.CovidHospitClage10;

public class CovidHospitClage10Writer implements ItemWriter<CovidHospitClage10> {
	@Autowired
	private CovidHospitClage10Dao covidHospitClage10Dao;
	@Override
	public void write(List<? extends CovidHospitClage10> items) throws Exception {
		covidHospitClage10Dao.saveAllAndFlush(items);
	}
}
