package com.covid.dev.batch;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.covid.dev.batch.processor.CovidHospTxadAgeFraProcessor;
import com.covid.dev.batch.reader.CovidHospTxadAgeFraReader;
import com.covid.dev.batch.writer.CovidHospTxadAgeFraWriter;
import com.covid.dev.util.BatchUtils;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private CovidHospTxadAgeFraWriter codAgeFraWriter;
	
	@Autowired 
	private CovidHospTxadAgeFraProcessor covidHospTxadAgeFraProcessor;
	
	@Autowired
	private CovidHospTxadAgeFraReader covidHospTxadAgeFraReader;
	
	public Step setp() {
		return null;
	}
	
}
