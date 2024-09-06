package com.pwit.companycrud.company.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record TeamResponse(UUID id, String name, ProjectResponse project,
                           LocalDateTime creationTime, LocalDateTime updateTime) {
}
