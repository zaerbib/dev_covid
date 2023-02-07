package com.covid.dev.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.covid.dev.repository.CovidHospTxadAgeFraDao;
import com.covid.dev.data.CovidHospTxadAgeFra;

@Component
public class CovidHospTxadAgeFraWriter implements ItemWriter<CovidHospTxadAgeFra> {
	@Autowired
	private CovidHospTxadAgeFraDao covidHospTxadAgeFraDao;

	@Override
	public void write(List<? extends CovidHospTxadAgeFra> items) throws Exception {
		covidHospTxadAgeFraDao.saveAllAndFlush(items);
	}
}
