package com.covid.dev.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.covid.dev.batch.processor.CovidHospTxadAgeFraProcessor;
import com.covid.dev.batch.reader.CovidHospTxadAgeFraReader;
import com.covid.dev.batch.writer.CovidHospTxadAgeFraWriter;
import com.covid.dev.data.CovidHospTxadAgeFra;
import com.covid.dev.dto.CovidHospTxadAgeFraDto;
import com.covid.dev.util.BatchUtils;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private CovidHospTxadAgeFraReader covidHospTxadAgeFraReader;
	
	@Autowired
	private CovidHospTxadAgeFraWriter covidHospTxadAgeFraWriter;
	
	@Autowired
	private CovidHospTxadAgeFraProcessor covidHospTxadAgeFraProcessor;
	
	@Bean(name = "job1")
	public Job job1() {
		return jobBuilderFactory.get(BatchUtils.job1)
				.start(step1())
				.build();
	}
	
	@Bean
	public Step step1() {
		return stepBuilderFactory.get(BatchUtils.step1)
				.<CovidHospTxadAgeFraDto, CovidHospTxadAgeFra> chunk(5)
				.reader(covidHospTxadAgeFraReader.reader())
				.processor(covidHospTxadAgeFraProcessor)
				.writer(covidHospTxadAgeFraWriter)
				.build();
	}	
}
