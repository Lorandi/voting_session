package com.lorandi.voting_session.util.creator;

import com.lorandi.voting_session.dto.SurveyDTO;
import com.lorandi.voting_session.dto.SurveyRequestDTO;
import com.lorandi.voting_session.dto.SurveyUpdateDTO;
import com.lorandi.voting_session.entity.Survey;

import java.time.LocalDateTime;

import static com.lorandi.voting_session.util.PodamFactory.podam;
import static com.lorandi.voting_session.util.mapper.MapperConstants.surveyMapper;


public class SurveyCreator {

    public static final Survey survey = podam.manufacturePojo(Survey.class).withEndTime(LocalDateTime.now().plusMinutes(1L));
    public static final SurveyDTO surveyDTO = surveyMapper.buildSurveyDTO(survey);

    public static SurveyRequestDTO createSurveyRequestDTO() {
        return SurveyRequestDTO.builder()
                .minutes(2L)
                .question(survey.getQuestion())
                .build();
    }

    public static SurveyUpdateDTO surveyUpdateDTO() {
        return SurveyUpdateDTO.builder()
                .id(survey.getId())
                .minutes(2L)
                .question(survey.getQuestion())
                .build();
    }
}
