package com.covid.dev.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.covid.dev.dao.CovidHospTxadFraDao;
import com.covid.dev.data.CovidHospTxadFra;

public class CovidHospTxadFraWriter implements ItemWriter<CovidHospTxadFra>{
	@Autowired
	private CovidHospTxadFraDao covidHospTxadFraDao;

	@Override
	public void write(List<? extends CovidHospTxadFra> items) throws Exception {
		covidHospTxadFraDao.saveAllAndFlush(items);
	}
}
