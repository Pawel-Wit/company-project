package com.pwit.companycrud.company.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CompanyResponse (UUID id, String name, @JsonInclude(NON_EMPTY) List<DepartmentResponse> departments,
                              LocalDateTime createdDate, LocalDateTime lastModifiedDate) {


}


