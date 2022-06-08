package com.covid.dev.batch.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;

import com.covid.dev.dto.CovidHospitIncidDto;
import com.covid.dev.util.SystemUtils;

public class CovidHospitIncidReader {

	@Autowired
	private SystemUtils systemUtils;
	
	/**
	 * read line from file 
	 * @return
	 */
	public FlatFileItemReader<CovidHospitIncidDto> reader() {
		FlatFileItemReader<CovidHospitIncidDto> reader = new FlatFileItemReader<>();
		
		reader.setResource(new FileSystemResource(systemUtils.getEntrepo2()));
		reader.setLinesToSkip(1);
		reader.setLineMapper(lineMapper());
		return reader;
	}
	
	private DelimitedLineTokenizer delimit1() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setNames(new String[] {"reg", "jour", "PourAvec", "tx_indic_7J_DC", "tx_indic_7J_hosp", "tx_indic_7J_SC", "tx_prev_hosp", "tx_prev_SC"});
		return tokenizer;
	}
	
	private BeanWrapperFieldSetMapper<CovidHospitIncidDto> fieldMapper1(){
		BeanWrapperFieldSetMapper<CovidHospitIncidDto> beanMapper = new BeanWrapperFieldSetMapper<>();
		beanMapper.setTargetType(CovidHospitIncidDto.class);
		return beanMapper;
	}
	
	private DefaultLineMapper<CovidHospitIncidDto> lineMapper(){
		DefaultLineMapper<CovidHospitIncidDto> mapper = new DefaultLineMapper<>();
		mapper.setLineTokenizer(delimit1());
		mapper.setFieldSetMapper(fieldMapper1());
		return mapper;
	}

}
