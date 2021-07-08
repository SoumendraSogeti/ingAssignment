package com.ing.assignment.dto;

import com.ing.assignment.domain.Agreements;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class AgreementDTO {
    List<Agreements> agreements;

}
