package com.covid.dev.batch.mapper;

import com.covid.dev.dto.CovidHospitIncidDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
@Slf4j
public class CovidHospitIncidMapper implements FieldSetMapper<CovidHospitIncidDto> {
    @Override
    public CovidHospitIncidDto mapFieldSet(FieldSet fieldSet) throws BindException {
        CovidHospitIncidDto covidHospitIncidDto = new CovidHospitIncidDto();
        covidHospitIncidDto.setDep(parseStringToInteger(fieldSet.readString("dep")));
        try {
            covidHospitIncidDto.setJour(new SimpleDateFormat("yyyy-mm-dd").parse(fieldSet.readString("jour")));
        } catch (ParseException e) {
            log.info("Parse failed !!!");
        }
        covidHospitIncidDto.setIncidHosp(parseStringToInteger(fieldSet.readString("incid_hosp")));
        covidHospitIncidDto.setIncidRea(parseStringToInteger(fieldSet.readString("incid_rea")));
        covidHospitIncidDto.setIncidDc(parseStringToInteger(fieldSet.readString("incid_dc")));
        covidHospitIncidDto.setIncidRad(parseStringToInteger(fieldSet.readString("incid_rad")));
        return covidHospitIncidDto;
    }

    private Integer parseStringToInteger(String str) {
        return str.equals("") || str.equals("NA") ? 0 : Integer.parseInt(str);
    }
}
