package com.pwit.companycrud.company.controller.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record ManagerResponse(UUID id, String name, String email, String phoneNumber,
                              LocalDateTime creationTime, LocalDateTime updateTime) {

}
