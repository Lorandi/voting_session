package com.lorandi.voting_session.dto;

import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Value
@With
@Jacksonized
@Builder
public class SurveyRequestDTO {

    @NotNull
    LocalDateTime endTime;
    @NotNull
    String question;
}
