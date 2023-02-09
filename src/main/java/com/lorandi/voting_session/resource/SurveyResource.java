package com.lorandi.voting_session.resource;

import com.lorandi.voting_session.dto.SurveyDTO;
import com.lorandi.voting_session.dto.SurveyRequestDTO;
import com.lorandi.voting_session.dto.SurveyUpdateDTO;
import com.lorandi.voting_session.service.SurveyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/survey")
@RequiredArgsConstructor
public class SurveyResource {

    private final SurveyService service;

    @GetMapping("/{id}")
    @Operation(summary = "Search survey by id",
            responses = {@ApiResponse(responseCode = "200", description = "Resource successfully retrieved",
                    content = @Content(schema = @Schema(implementation = SurveyDTO.class)))})
    public SurveyDTO findById( @Valid @PathVariable Long id) {
        return service.findDTOById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @Operation(summary = "Create survey",
            responses = {@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = SurveyDTO.class)))})
    public SurveyDTO create( @Valid @RequestBody SurveyRequestDTO requestDTO) {
        return service.create(requestDTO);
    }

    @PutMapping
    @Operation(summary = "Update survey by id",
            responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = SurveyDTO.class)))})
    public SurveyDTO update( @Valid @RequestBody SurveyUpdateDTO surveyRequest) {
        return service.update(surveyRequest);
    }

    @GetMapping
    @Operation(summary = "Find all surveys",
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = SurveyDTO.class))))})
    public Page<SurveyDTO> findAll(@RequestParam(required = false) Optional<String> survey,
                                   @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                           Optional<List<LocalDateTime>> endTime,
                                   @RequestParam(defaultValue = "0") Integer page,
                                   @RequestParam(defaultValue = "10") Integer size,
                                   @RequestParam(defaultValue = "id") String sort,
                                   @RequestParam(defaultValue = "DESC") Sort.Direction direction) {
        return service.findAll(survey, endTime, PageRequest.of(page, size, Sort.by(direction, sort)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete survey by id",
            responses = {@ApiResponse(responseCode = "204", description = "Survey successfully deleted")})
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
