package com.lorandi.voting_session.dto;

import com.lorandi.voting_session.enums.ElectorStatusEnum;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotNull;

@Value
@With
@Jacksonized
@Builder
public class ElectorRequestDTO {

    @NotNull
    String cpf;
    ElectorStatusEnum status;
}
