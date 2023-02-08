package com.lorandi.voting_session.repository;

import com.lorandi.voting_session.entity.Elector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectorRepository extends JpaRepository<Elector, Long>, JpaSpecificationExecutor<Elector> {
}
