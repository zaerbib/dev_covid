package com.covid.dev.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.covid.dev.repository.CovidHospitIncidRegDao;
import com.covid.dev.data.CovidHospitIncidReg;

@Component
public class CovidHospitIncidRegWriter implements ItemWriter<CovidHospitIncidReg> {
	@Autowired
	private CovidHospitIncidRegDao covidHospitIncidRegDao;

	@Override
	public void write(List<? extends CovidHospitIncidReg> items) throws Exception {
		covidHospitIncidRegDao.saveAllAndFlush(items);
	}
}
