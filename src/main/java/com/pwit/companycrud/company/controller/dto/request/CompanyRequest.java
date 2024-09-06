package com.pwit.companycrud.company.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record CompanyRequest(@NotBlank @Length(min = 2, max = 255) String name,List<DepartmentRequest> departments) {

}
