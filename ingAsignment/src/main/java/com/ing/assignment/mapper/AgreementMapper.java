package com.ing.assignment.mapper;

import com.ing.assignment.domain.Agreements;
import com.ing.assignment.dto.AgreementDTO;
import com.ing.assignment.repo.UserAgreementEntity;

import java.util.ArrayList;
import java.util.List;

public class AgreementMapper {



    public static List<Agreements> toAgreementDomain(List<UserAgreementEntity> userAgreementEntities) {

        List<Agreements> agreements = new ArrayList<>();
        for (UserAgreementEntity userAgreementEntity : userAgreementEntities) {
            agreements.add(Agreements.builder().account(userAgreementEntity.getAgreementAccount())
                    .type(userAgreementEntity.getAgreementType()).build());
        }
        return agreements;
    }

    public static AgreementDTO toAgreementDTO(List<Agreements> agreements){

        return AgreementDTO.builder().agreements(agreements).build();
    }

}
