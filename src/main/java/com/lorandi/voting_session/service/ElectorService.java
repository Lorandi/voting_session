package com.lorandi.voting_session.service;

import com.lorandi.voting_session.dto.ElectorDTO;
import com.lorandi.voting_session.dto.ElectorRequestDTO;
import com.lorandi.voting_session.dto.ElectorUpdateDTO;
import com.lorandi.voting_session.entity.Elector;
import com.lorandi.voting_session.helper.MessageHelper;
import com.lorandi.voting_session.repository.ElectorRepository;
import com.lorandi.voting_session.repository.spec.ElectorSpecification;
import com.lorandi.voting_session.util.validator.CPFValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static com.lorandi.voting_session.exception.ErrorCodeEnum.ERROR_ELECTOR_NOT_FOUND;
import static com.lorandi.voting_session.exception.ErrorCodeEnum.ERROR_INVALID_CPF;
import static com.lorandi.voting_session.util.mapper.MapperConstants.electorMapper;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class ElectorService {

    private final ElectorRepository repository;
    private final MessageHelper messageHelper;

    public ElectorDTO create(final ElectorRequestDTO requestDTO) {

        if (!CPFValidator.isValidCPF(requestDTO.getCPF())) {
            log.error(messageHelper.get(ERROR_INVALID_CPF, requestDTO.getCPF()));
            throw new ResponseStatusException(BAD_REQUEST, messageHelper.get(ERROR_INVALID_CPF, requestDTO.getCPF()));
        }

        return electorMapper.buildElectorDTO(repository.save(electorMapper.buildElector(requestDTO)));
    }

    public ElectorDTO update(final ElectorUpdateDTO updateDTO) {

        if (!CPFValidator.isValidCPF(updateDTO.getCPF())) {
            log.error(messageHelper.get(ERROR_INVALID_CPF, updateDTO.getCPF()));
            throw new ResponseStatusException(NOT_FOUND, messageHelper.get(ERROR_INVALID_CPF, updateDTO.getCPF()));
        }

        var elector = findById(updateDTO.getId());

        return electorMapper.buildElectorDTO(repository.save(elector));
    }

    public Elector findById(final Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error(messageHelper.get(ERROR_ELECTOR_NOT_FOUND, id.toString()));
            return new ResponseStatusException(NOT_FOUND, messageHelper.get(ERROR_ELECTOR_NOT_FOUND, id.toString()));
        });
    }

    public ElectorDTO findDTOById(final Long id) {
        Elector elector = findById(id);
        return electorMapper.buildElectorDTO(elector);
    }

    public void delete(final Long id) {
        Elector elector = findById(id);
        repository.delete(elector);
    }

    public Page<ElectorDTO> findAll(final Optional<String> cpf, final Pageable pageable) {
        return repository.findAll(ElectorSpecification.builder().cpf(cpf).build(), pageable).map(electorMapper::buildElectorDTO);
    }
}
