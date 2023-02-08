package com.lorandi.voting_session.dto;

import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Value
@With
@Jacksonized
@Builder
public class SurveyDTO {
    Long id;
    LocalDateTime endTime;
    String question;
}
