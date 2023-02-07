package com.covid.dev.batch.mapper;

import com.covid.dev.dto.CovidHospitEtabDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
@Slf4j
public class CovidHospitEtabMapper implements FieldSetMapper<CovidHospitEtabDto> {
    @Override
    public CovidHospitEtabDto mapFieldSet(FieldSet fieldSet) throws BindException {
        CovidHospitEtabDto covidHospitEtabDto = new CovidHospitEtabDto();
        covidHospitEtabDto.setDep(parseStringToInteger(fieldSet.readString("dep")));
        try {
            covidHospitEtabDto.setJour(new SimpleDateFormat("yyyy-MM-dd").parse(fieldSet.readString("jour")));
        } catch (ParseException e) {
            log.info("Parse failed !!!!");
        }
        covidHospitEtabDto.setNb(parseStringToInteger(fieldSet.readString("nb")));

        return covidHospitEtabDto;
    }

    private Integer parseStringToInteger(String str) {
        return str.equals("") || str.equals("NA")
                || str.contains("A") || str.contains("B") ? 0 : Integer.parseInt(str);
    }
}
