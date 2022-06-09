package com.covid.dev.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;

import com.covid.dev.data.CovidHospitEtab;
import com.covid.dev.dto.CovidHospitEtabDto;

public class CovidHospitEtabProcessor implements ItemProcessor<CovidHospitEtabDto, CovidHospitEtab>{

	@Override
	public CovidHospitEtab process(CovidHospitEtabDto item) throws Exception {
		CovidHospitEtab dataItem = new CovidHospitEtab();
		BeanUtils.copyProperties(item, dataItem);
		return dataItem;
	}

}
