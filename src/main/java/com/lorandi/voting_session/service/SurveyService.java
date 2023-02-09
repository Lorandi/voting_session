package com.lorandi.voting_session.service;

import com.lorandi.voting_session.dto.SurveyDTO;
import com.lorandi.voting_session.dto.SurveyRequestDTO;
import com.lorandi.voting_session.dto.SurveyUpdateDTO;
import com.lorandi.voting_session.entity.Survey;
import com.lorandi.voting_session.helper.MessageHelper;
import com.lorandi.voting_session.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.lorandi.voting_session.exception.ErrorCodeEnum.ERROR_SURVEY_NOT_FOUND;
import static com.lorandi.voting_session.util.mapper.MapperConstants.surveyMapper;
import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class SurveyService {

    private final SurveyRepository repository;
    private final MessageHelper messageHelper;
    private final static Long DEFAULT_MINUTES = 1L;

    public SurveyDTO create(final SurveyRequestDTO requestDTO) {

        var minutes = isNull(requestDTO.getMinutes()) ? DEFAULT_MINUTES : requestDTO.getMinutes();

        var survey = surveyMapper.buildSurveyDTO(repository.save(surveyMapper.buildSurvey(requestDTO)
                .withEndTime(LocalDateTime.now().plusMinutes(minutes))));
        return survey;
    }

    public SurveyDTO update(final SurveyUpdateDTO updateDTO) {
        var minutes = isNull(updateDTO.getMinutes()) ? DEFAULT_MINUTES : updateDTO.getMinutes();

        var survey = findById(updateDTO.getId());

        var updateSurvey = surveyMapper.buildSurveyDTO(repository.save(survey
                .withQuestion(updateDTO.getQuestion())
                .withEndTime(LocalDateTime.now().plusMinutes(minutes))));

        return updateSurvey;
    }

    public Survey findById(final Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error(messageHelper.get(ERROR_SURVEY_NOT_FOUND, id.toString()));
            return new ResponseStatusException(NOT_FOUND, messageHelper.get(ERROR_SURVEY_NOT_FOUND, id.toString()));
        });
    }

    public SurveyDTO findDTOById(final Long id) {
        Survey survey = findById(id);
        return surveyMapper.buildSurveyDTO(survey);
    }

    public void delete(final Long id) {
        Survey survey = findById(id);
        repository.delete(survey);
    }

    public Page<SurveyDTO> findAll(final Pageable pageable) {
        return repository.findAll(pageable).map(surveyMapper::buildSurveyDTO);
    }

}
