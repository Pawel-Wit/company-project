package com.pwit.companycrud.company.controller.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record ManagerRequest(@NotBlank @Length(min = 2, max = 255) String name, @NotBlank @Email String email,
                             @NotBlank @Length(min = 9, max = 12) String phoneNumber) {

}
