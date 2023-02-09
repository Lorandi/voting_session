package com.lorandi.voting_session.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {

    ERROR_GENERIC_EXCEPTION("error.generic.exception"),
    ERROR_DATE_FORMAT("error.date.format"),
    ERROR_SURVEY_NOT_FOUND("error.survey.not.found"),
    ERROR_ELECTOR_NOT_FOUND("error.elector.not.found"),
    ERROR_VOTE_NOT_FOUND("error.vote.not.found"),
    ERROR_INVALID_CPF("error.invalid.cpf");



    private final String messageKey;
}
