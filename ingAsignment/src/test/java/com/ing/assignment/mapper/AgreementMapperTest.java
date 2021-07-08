package com.ing.assignment.mapper;

import com.ing.assignment.domain.Agreements;
import com.ing.assignment.domain.UserAgreementNumber;
import com.ing.assignment.dto.AgreementDTO;
import com.ing.assignment.repo.UserAgreementEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AgreementMapperTest {
    @Test
    public void toAgreementDomainTest(){
        List<UserAgreementEntity> userAgreementEntities = new ArrayList<>();
        UserAgreementEntity userAgreementEntity = new UserAgreementEntity();
        userAgreementEntity.setAgreementType("IBAN");
        userAgreementEntity.setUserId(1);
        userAgreementEntity.setAgreementAccount(1234567890);
        userAgreementEntities.add(userAgreementEntity);
        List<Agreements> agreements = AgreementMapper.toAgreementDomain(userAgreementEntities);
        for(Agreements agreement:agreements){
            assertThat(agreement.getAccount()).isEqualTo(userAgreementEntity.getAgreementAccount());
            assertThat(agreement.getType()).isEqualTo(userAgreementEntity.getAgreementType());
        }
    }
    @Test
    public void toAgreementDTOTest(){
        List<Agreements> agreements = new ArrayList<>();
        Agreements agreement =Agreements.builder().account(1234567890).type("IBAN").build();
        agreements.add(agreement);
        AgreementDTO agreementDTO = AgreementMapper.toAgreementDTO(agreements);
        assertThat(agreementDTO.getAgreements().get(0).getType()).isEqualTo(agreement.getType());
        assertThat(agreementDTO.getAgreements().get(0).getAccount()).isEqualTo(agreement.getAccount());
    }
}
