package com.lorandi.voting_session.resource;

import com.lorandi.voting_session.dto.ElectorDTO;
import com.lorandi.voting_session.dto.ElectorRequestDTO;
import com.lorandi.voting_session.dto.ElectorUpdateDTO;
import com.lorandi.voting_session.service.ElectorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/elector")
@RequiredArgsConstructor
public class ElectorResource {

    private final ElectorService service;

    @GetMapping("/{id}")
    @Operation(summary = "Search elector by id",
            responses = {@ApiResponse(responseCode = "200", description = "Resource successfully retrieved",
                    content = @Content(schema = @Schema(implementation = ElectorDTO.class)))})
    public ElectorDTO findById( @Valid @PathVariable Long id) {
        return service.findDTOById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @Operation(summary = "Create elector",
            responses = {@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = ElectorDTO.class)))})
    public ElectorDTO create( @Valid @RequestBody ElectorRequestDTO requestDTO) {
        return service.create(requestDTO);
    }

    @PutMapping
    @Operation(summary = "Update elector by id",
            responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ElectorDTO.class)))})
    public ElectorDTO update( @Valid @RequestBody ElectorUpdateDTO updateDTO) {
        return service.update(updateDTO);
    }

    @GetMapping
    @Operation(summary = "Find all electors",
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = ElectorDTO.class))))})
    public Page<ElectorDTO> findAll(@RequestParam(required = false) Optional<String> cpf,
                                   @RequestParam(defaultValue = "0") Integer page,
                                   @RequestParam(defaultValue = "10") Integer size,
                                   @RequestParam(defaultValue = "id") String sort,
                                   @RequestParam(defaultValue = "DESC") Sort.Direction direction) {
        return service.findAll(cpf, PageRequest.of(page, size, Sort.by(direction, sort)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete elector by id",
            responses = {@ApiResponse(responseCode = "204", description = "Elector successfully deleted")})
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
