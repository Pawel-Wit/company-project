package com.pwit.companycrud.company.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record TeamRequest(@NotBlank @Length(min = 2, max = 255) String name, ProjectRequest project) {
}
