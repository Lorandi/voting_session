package com.lorandi.voting_session.repository;

import com.lorandi.voting_session.entity.Elector;
import com.lorandi.voting_session.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectorRepository extends JpaRepository<Elector, Long>, JpaSpecificationExecutor<Elector> {
    List<Elector> findAllByCpf(String cpf);
}
