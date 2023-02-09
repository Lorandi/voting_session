package com.lorandi.voting_session.util.mapper;

import com.lorandi.voting_session.dto.ElectorDTO;
import com.lorandi.voting_session.dto.ElectorRequestDTO;
import com.lorandi.voting_session.entity.Elector;
import org.mapstruct.Mapper;

@Mapper
public interface ElectorMapper {
    Elector buildElector(ElectorRequestDTO requestDTO);
    ElectorDTO buildElectorDTO(Elector elector);
}
