package com.lorandi.voting_session.dto;

import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Value
@With
@Jacksonized
@Builder
public class ResultDTO {
    SurveyDTO survey;
    Long approves;
    Long reproves;
    String result;
}
