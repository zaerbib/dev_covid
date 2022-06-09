package com.covid.dev.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.covid.dev.dao.CovidHospitDao;
import com.covid.dev.data.CovidHospit;

@Repository
public class CovidHospitWriter implements ItemWriter<CovidHospit> {
	@Autowired
	private CovidHospitDao covidHospitDao;

	@Override
	public void write(List<? extends CovidHospit> items) throws Exception {
		covidHospitDao.saveAllAndFlush(items);
	}
}
