package com.covid.dev.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.covid.dev.repository.CovidHospTxadRegDao;
import com.covid.dev.data.CovidHospTxadReg;

@Component
public class CovidHospTxadRegWriter implements ItemWriter<CovidHospTxadReg> {
	@Autowired
	private CovidHospTxadRegDao covidHospTxadRegDao;

	@Override
	public void write(List<? extends CovidHospTxadReg> items) throws Exception {
		covidHospTxadRegDao.saveAllAndFlush(items);
	}

}
