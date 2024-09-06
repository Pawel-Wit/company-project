package com.pwit.companycrud.company.controller.dto.request;

import jakarta.validation.constraints.Email;

public record ManagerRequest(String name, @Email String email, String phoneNumber) {

}
