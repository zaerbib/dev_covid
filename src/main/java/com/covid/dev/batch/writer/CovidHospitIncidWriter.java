package com.covid.dev.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.covid.dev.dao.CovidHospitIncidDao;
import com.covid.dev.data.CovidHospitIncid;

public class CovidHospitIncidWriter implements ItemWriter<CovidHospitIncid> {
	@Autowired
	private  CovidHospitIncidDao covidHospitIncidDao;

	@Override
	public void write(List<? extends CovidHospitIncid> items) throws Exception {
		covidHospitIncidDao.saveAllAndFlush(items);
	}
}
