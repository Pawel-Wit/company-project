package com.pwit.companycrud.company.controller.dto.request;

import java.util.List;

public record DepartmentRequest(String name, List<TeamRequest> teams) {
}
