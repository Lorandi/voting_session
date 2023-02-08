package com.lorandi.voting_session.dto;

import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotNull;

@Value
@With
@Jacksonized
@Builder
public class VoteUpdateDTO {
    @NotNull
    Long id;
    @NotNull
    Long surveyId;
    @NotNull
    Long voterId;
    @NotNull
    Boolean approval;
}
