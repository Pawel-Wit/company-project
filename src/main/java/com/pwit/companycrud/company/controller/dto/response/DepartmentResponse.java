package com.pwit.companycrud.company.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

public record DepartmentResponse(UUID id, String name, @JsonInclude(NON_EMPTY) List<TeamResponse> teams,
                                 LocalDateTime creationTime, LocalDateTime updateTime) {
}
