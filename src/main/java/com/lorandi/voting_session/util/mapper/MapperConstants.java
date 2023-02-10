package com.lorandi.voting_session.util.mapper;

import org.mapstruct.factory.Mappers;

public class MapperConstants {

    private MapperConstants() {

    }

    public static final SurveyMapper surveyMapper = Mappers.getMapper(SurveyMapper.class);
    public static final ElectorMapper electorMapper = Mappers.getMapper(ElectorMapper.class);
    public static final VoteMapper voteMapper = Mappers.getMapper(VoteMapper.class);
}