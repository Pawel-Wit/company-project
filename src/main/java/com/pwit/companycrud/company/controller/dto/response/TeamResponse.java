package com.pwit.companycrud.company.controller.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record TeamResponse(UUID id, String name, ProjectResponse project,
                           LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
}
