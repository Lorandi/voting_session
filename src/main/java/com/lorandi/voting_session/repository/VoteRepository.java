package com.lorandi.voting_session.repository;

import com.lorandi.voting_session.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long>, JpaSpecificationExecutor<Vote> {
    List<Vote> findAllBySurveyIdAndElectorId(Long surveyId, Long electorId);

}
