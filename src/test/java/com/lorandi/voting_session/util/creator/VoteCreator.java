package com.lorandi.voting_session.util.creator;

import com.lorandi.voting_session.dto.VoteDTO;
import com.lorandi.voting_session.dto.VoteRequestDTO;
import com.lorandi.voting_session.dto.VoteUpdateDTO;
import com.lorandi.voting_session.entity.Vote;


import static com.lorandi.voting_session.util.PodamFactory.podam;
import static com.lorandi.voting_session.util.creator.ElectorCreator.elector;
import static com.lorandi.voting_session.util.creator.SurveyCreator.survey;
import static com.lorandi.voting_session.util.mapper.MapperConstants.voteMapper;


public class VoteCreator {

    public final static String VALID_CPF = "679.530.080-33";
    public final static String INVALID_CPF = "679.530.080-37";


    public static final Vote vote = podam.manufacturePojo(Vote.class);
    public static final VoteDTO voteDTO = voteMapper.buildVoteDTO(vote);

    public static VoteRequestDTO createVoteRequestDTO() {
        return VoteRequestDTO.builder()
                .electorId(elector.getId())
                .surveyId(survey.getId())
                .approval(Boolean.TRUE)
                .build();
    }


    public static VoteUpdateDTO voteUpdateDTO() {
        return VoteUpdateDTO.builder()
                .electorId(elector.getId())
                .surveyId(survey.getId())
                .approval(Boolean.TRUE)
                .build();
    }
}
