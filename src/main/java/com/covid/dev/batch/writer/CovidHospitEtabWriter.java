package com.covid.dev.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.covid.dev.dao.CovidHospitEtabDao;
import com.covid.dev.data.CovidHospitEtab;

public class CovidHospitEtabWriter implements ItemWriter<CovidHospitEtab> {
	@Autowired
	private CovidHospitEtabDao covidHospitEtabDao;

	@Override
	public void write(List<? extends CovidHospitEtab> items) throws Exception {
		covidHospitEtabDao.saveAllAndFlush(items);
	}
}
