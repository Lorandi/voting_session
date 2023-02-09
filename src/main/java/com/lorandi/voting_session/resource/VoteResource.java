package com.lorandi.voting_session.resource;

import com.lorandi.voting_session.dto.VoteDTO;
import com.lorandi.voting_session.dto.VoteRequestDTO;
import com.lorandi.voting_session.dto.VoteUpdateDTO;
import com.lorandi.voting_session.service.VoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/vote")
@RequiredArgsConstructor
public class VoteResource {

    private final VoteService service;

    @GetMapping("/{id}")
    @Operation(summary = "Search vote by id",
            responses = {@ApiResponse(responseCode = "200", description = "Resource successfully retrieved",
                    content = @Content(schema = @Schema(implementation = VoteDTO.class)))})
    public VoteDTO findById( @Valid @PathVariable Long id) {
        return service.findDTOById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @Operation(summary = "Create vote",
            responses = {@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = VoteDTO.class)))})
    public VoteDTO create( @Valid @RequestBody VoteRequestDTO requestDTO) {
        return service.create(requestDTO);
    }

    @PutMapping
    @Operation(summary = "Update vote by id",
            responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = VoteDTO.class)))})
    public VoteDTO update( @Valid @RequestBody VoteUpdateDTO voteRequest) {
        return service.update(voteRequest);
    }

    @GetMapping
    @Operation(summary = "Find all votes",
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = VoteDTO.class))))})
    public Page<VoteDTO> findAll(  @RequestParam(defaultValue = "0") Integer page,
                                   @RequestParam(defaultValue = "10") Integer size,
                                   @RequestParam(defaultValue = "id") String sort,
                                   @RequestParam(defaultValue = "DESC") Sort.Direction direction) {
        return service.findAll(PageRequest.of(page, size, Sort.by(direction, sort)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete vote by id",
            responses = {@ApiResponse(responseCode = "204", description = "Vote successfully deleted")})
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
