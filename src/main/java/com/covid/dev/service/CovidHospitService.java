package com.covid.dev.service;

import com.covid.dev.repository.CovidHospitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@Slf4j
public class CovidHospitService {

    private final CovidHospitRepository covidHospitRepository;

    public CovidHospitService(CovidHospitRepository covidHospitRepository) {
        this.covidHospitRepository = covidHospitRepository;
    }

    public Mono<Integer> calculGlobalSurUnAnTotal(String annee) {
        return Mono.just(covidHospitRepository.findCovidHospitByAnne(annee))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(item -> log.info("Processing size : {}", item.size()))
                .map(item -> item.stream().map(elt -> elt.getHosp()).reduce(0, (sub, element) -> sub+element))
                .doOnSuccess(item -> log.info("Process done ! total is {}", item));
    }

    public Mono<Integer> calculGlobalSurUnMoisTotal(String annee) {
        return Mono.just(covidHospitRepository.findCovidHospitByAnne(annee))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(item -> log.info("Processing size : {}", item.size()))
                .map(item -> item.stream().map(it -> it.getHosp()).reduce(0, (subtotal, elt) ->subtotal + elt))
                .doOnSuccess(item -> log.info("Process done ! total : {}", item));
    }
}
