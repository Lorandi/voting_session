package com.lorandi.voting_session.util.mapper;

import com.lorandi.voting_session.dto.VoteDTO;
import com.lorandi.voting_session.dto.VoteRequestDTO;
import com.lorandi.voting_session.entity.Vote;
import org.mapstruct.Mapper;

@Mapper
public interface VoteMapper {
    Vote buildVote(VoteRequestDTO requestDTO);
    VoteDTO buildVoteDTO(Vote vote);
}
