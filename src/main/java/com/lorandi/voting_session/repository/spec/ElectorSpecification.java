package com.lorandi.voting_session.repository.spec;

import com.lorandi.voting_session.entity.Elector;
import lombok.Builder;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Optional;

@Builder
public class ElectorSpecification implements Specification<Elector> {
    @Builder.Default
    private final transient Optional<String> cpf = Optional.empty();


    @Override
    public Predicate toPredicate(Root<Elector> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {
        final var predicate = new ArrayList<Predicate>();
        cpf.ifPresent(s -> predicate.add(root.get("cpf").in(s)));
        criteriaQuery.distinct(true);
        return builder.and(predicate.toArray(new Predicate[0]));
    }
}
