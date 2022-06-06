package com.covid.dev.util.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.covid.dev.clienthttp.HttpGetDataFiles;
import com.covid.dev.util.HttpCovidURL;
import com.covid.dev.util.SystemUtils;

@Component
public class FileGetRunner {
	@Autowired
	private HttpGetDataFiles runner;
	
	@Autowired
	private SystemUtils systemUtils;
	
	private Logger logger = LoggerFactory.getLogger(FileGetRunner.class);
	
	@EventListener(ApplicationReadyEvent.class)
	public void getFilesRunner() {
		
		logger.info("---- début téléchargement ----");
		runner.downloadFromSource(HttpCovidURL.COVID_HOSP_TXAD_REG, systemUtils.getEntrepo1());
		runner.downloadFromSource(HttpCovidURL.COVID_HOSP_TXAD_REG, systemUtils.getEntrepo2());
		runner.downloadFromSource(HttpCovidURL.COVID_HOSP_TXAD_REG, systemUtils.getEntrepo3());
		runner.downloadFromSource(HttpCovidURL.COVID_HOSP_TXAD_REG, systemUtils.getEntrepo4());
		runner.downloadFromSource(HttpCovidURL.COVID_HOSP_TXAD_REG, systemUtils.getEntrepo5());
		runner.downloadFromSource(HttpCovidURL.COVID_HOSP_TXAD_REG, systemUtils.getEntrepo6());
		runner.downloadFromSource(HttpCovidURL.COVID_HOSP_TXAD_REG, systemUtils.getEntrepo7());
		runner.downloadFromSource(HttpCovidURL.COVID_HOSP_TXAD_REG, systemUtils.getEntrepo8());
		runner.downloadFromSource(HttpCovidURL.COVID_HOSP_TXAD_REG, systemUtils.getEntrepo9());
		logger.info("---- fin téléchargement ----");
	}
}
