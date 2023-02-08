package com.lorandi.voting_session.service;

import com.lorandi.voting_session.dto.SurveyDTO;
import com.lorandi.voting_session.dto.SurveyRequestDTO;
import com.lorandi.voting_session.helper.MessageHelper;
import com.lorandi.voting_session.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SurveyService {

    private final SurveyRepository repository;
    private final MessageHelper messageHelper;

//    public SurveyDTO create (final SurveyRequestDTO requestDTO){
//
//
//    }
}
