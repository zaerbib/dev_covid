package com.covid.dev.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.covid.dev.dao.CovidHospAdAgeDao;
import com.covid.dev.data.CovidHospAdAge;

@Component
public class CovidHospAdAgeWriter implements ItemWriter<CovidHospAdAge> {
	@Autowired
	private CovidHospAdAgeDao covidHospAdAgeDao;

	@Override
	public void write(List<? extends CovidHospAdAge> items) throws Exception {
		covidHospAdAgeDao.saveAllAndFlush(items);
	}

}
