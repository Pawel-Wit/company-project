package com.pwit.companycrud.company.controller.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record ProjectResponse(UUID id, String name, ManagerResponse manager,
                              LocalDateTime creationTime, LocalDateTime updateTime) {
}
