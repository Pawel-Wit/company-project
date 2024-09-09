package com.pwit.companycrud.company.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record DepartmentRequest(@NotBlank @Length(min = 2, max = 255) String name, List<TeamRequest> teams) {
}
