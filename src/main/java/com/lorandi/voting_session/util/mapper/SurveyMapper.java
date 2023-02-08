package com.lorandi.voting_session.util.mapper;

import com.lorandi.voting_session.dto.SurveyDTO;
import com.lorandi.voting_session.dto.SurveyRequestDTO;
import com.lorandi.voting_session.entity.Survey;

public interface SurveyMapper {
    Survey buildSurvey(SurveyRequestDTO requestDTO);
    SurveyDTO buildSurveyDTO(Survey  survey);
}
