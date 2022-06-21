package com.covid.dev.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.covid.dev.batch.processor.CovidHospAdAgeProcessor;
import com.covid.dev.batch.processor.CovidHospTxadAgeFraProcessor;
import com.covid.dev.batch.processor.CovidHospTxadFraProcessor;
import com.covid.dev.batch.processor.CovidHospTxadRegProcessor;
import com.covid.dev.batch.processor.CovidHospitIncidRegProcessor;
import com.covid.dev.batch.reader.CovidHospAdAgeReader;
import com.covid.dev.batch.reader.CovidHospTxadAgeFraReader;
import com.covid.dev.batch.reader.CovidHospTxadFraReader;
import com.covid.dev.batch.reader.CovidHospTxadRegReader;
import com.covid.dev.batch.reader.CovidHospitIncidRegReader;
import com.covid.dev.batch.writer.CovidHospAdAgeWriter;
import com.covid.dev.batch.writer.CovidHospTxadAgeFraWriter;
import com.covid.dev.batch.writer.CovidHospTxadFraWriter;
import com.covid.dev.batch.writer.CovidHospTxadRegWriter;
import com.covid.dev.batch.writer.CovidHospitIncidRegWriter;
import com.covid.dev.data.CovidHospAdAge;
import com.covid.dev.data.CovidHospTxadAgeFra;
import com.covid.dev.data.CovidHospTxadFra;
import com.covid.dev.data.CovidHospTxadReg;
import com.covid.dev.data.CovidHospitIncidReg;
import com.covid.dev.dto.CovidHospAdAgeDto;
import com.covid.dev.dto.CovidHospTxadAgeFraDto;
import com.covid.dev.dto.CovidHospTxadFraDto;
import com.covid.dev.dto.CovidHospTxadRegDto;
import com.covid.dev.dto.CovidHospitIncidRegDto;
import com.covid.dev.util.BatchUtils;

@Configuration
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
	
	@Autowired
	private CovidHospTxadRegReader covidHospTxadRegReader;
	
	@Autowired
	private CovidHospTxadRegWriter covidHospTxadRegWriter;
	
	@Autowired
	private CovidHospTxadRegProcessor covidHospTxadRegProcessor;
	
	@Autowired
	private CovidHospTxadFraReader covidHospTxadFraReader;
	
	@Autowired
	private CovidHospTxadFraProcessor covidHospTxadFraProcessor;
	
	@Autowired
	private CovidHospTxadFraWriter covidHospTxadFraWriter; 
	
	@Autowired
	private CovidHospAdAgeReader covidHospAdAgeReader;
	
	@Autowired
	private CovidHospAdAgeProcessor covidHospAdAgeProcessor;
	
	@Autowired
	private CovidHospAdAgeWriter covidHospAdAgeWriter;
	
	@Autowired
	private CovidHospitIncidRegReader covidHospitIncidRegReader;
	
	@Autowired
	private CovidHospitIncidRegProcessor covidHospitIncidRegProcessor;
	
	@Autowired
	private CovidHospitIncidRegWriter covidHospitIncidRegWriter;
	
	@Bean(name = "job1")
	public Job job1() {
		return jobBuilderFactory.get(BatchUtils.job1)
				.start(step1())
				.next(step2())
				.next(step3())
				.next(step4())
				.next(step5())
				.build();
	}
	
	@Bean
	public Step step1() {
		return stepBuilderFactory.get(BatchUtils.step1)
				.<CovidHospTxadAgeFraDto, CovidHospTxadAgeFra> chunk(5)
				.reader(covidHospTxadAgeFraReader.reader())
				.processor(covidHospTxadAgeFraProcessor)
				.writer(covidHospTxadAgeFraWriter)
				.allowStartIfComplete(true)
				.build();
	}	
	
	@Bean
	public Step step2() {
		return stepBuilderFactory.get(BatchUtils.step2)
				.<CovidHospTxadRegDto, CovidHospTxadReg> chunk(5)
				.reader(covidHospTxadRegReader.reader())
				.processor(covidHospTxadRegProcessor)
				.writer(covidHospTxadRegWriter)
				.allowStartIfComplete(true)
				.build();
	}
	
	@Bean
	public Step step3() {
		return stepBuilderFactory.get(BatchUtils.step3)
				.<CovidHospTxadFraDto, CovidHospTxadFra> chunk(5)
				.reader(covidHospTxadFraReader.reader())
				.processor(covidHospTxadFraProcessor)
				.writer(covidHospTxadFraWriter)
				.allowStartIfComplete(true)
				.build();
	}
	
	@Bean
	public Step step4() {
		return stepBuilderFactory.get(BatchUtils.step4)
				.<CovidHospAdAgeDto, CovidHospAdAge> chunk(5)
				.reader(covidHospAdAgeReader.reader())
				.processor(covidHospAdAgeProcessor)
				.writer(covidHospAdAgeWriter)
				.allowStartIfComplete(true)
				.build();
	}
	
	@Bean
	public Step step5() {
		return stepBuilderFactory.get(BatchUtils.step5)
				.<CovidHospitIncidRegDto, CovidHospitIncidReg>chunk(5)
				.reader(covidHospitIncidRegReader.reader())
				.processor(covidHospitIncidRegProcessor)
				.writer(covidHospitIncidRegWriter)
				.allowStartIfComplete(true)
				.build();
	}
}
