package com.lorandi.voting_session.repository.spec;

import com.lorandi.voting_session.entity.Survey;
import lombok.Builder;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Builder
public class SurveySpecification implements Specification<Survey> {
    @Builder.Default
    private final transient Optional<String> survey = Optional.empty();
    @Builder.Default
    private final transient Optional<List<LocalDateTime>> endTime = Optional.empty();


    @Override
    public Predicate toPredicate(Root<Survey> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {
        final var predicate = new ArrayList<Predicate>();
        survey.ifPresent(s -> predicate.add(root.get("survey").in(s)));
        endTime.ifPresent(s -> predicate.add(root.get("endTime").in(s)));

        criteriaQuery.distinct(true);
        return builder.and(predicate.toArray(new Predicate[0]));
    }
}
