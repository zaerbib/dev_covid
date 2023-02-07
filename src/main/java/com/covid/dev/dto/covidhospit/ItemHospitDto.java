package com.covid.dev.dto.covidhospit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Les données rélatives aux hospitalisations uniquement
 */
@Data
@AllArgsConstructor
@Builder
public class ItemHospitDto {
    private Integer nombreHospit;
    private String mois;
    private String annee;
    private String dep;
}
