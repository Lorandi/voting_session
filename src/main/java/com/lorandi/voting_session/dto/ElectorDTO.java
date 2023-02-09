package com.lorandi.voting_session.dto;

import com.lorandi.voting_session.enums.ElectorStatusEnum;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Value
@With
@Jacksonized
@Builder
public class ElectorDTO {
    Long id;
    String cpf;
    ElectorStatusEnum status;
}
