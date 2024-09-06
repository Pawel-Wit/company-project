package com.pwit.companycrud.company.controller.mapper;

import com.pwit.companycrud.company.controller.dto.request.ManagerRequest;
import com.pwit.companycrud.company.controller.dto.request.ProjectRequest;
import com.pwit.companycrud.company.controller.dto.request.TeamRequest;
import com.pwit.companycrud.company.controller.dto.response.ManagerResponse;
import com.pwit.companycrud.company.controller.dto.response.ProjectResponse;
import com.pwit.companycrud.company.controller.dto.response.TeamResponse;
import com.pwit.companycrud.company.repository.model.ManagerEntity;
import com.pwit.companycrud.company.repository.model.ProjectEntity;
import com.pwit.companycrud.company.repository.model.TeamEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, injectionStrategy = CONSTRUCTOR)
public interface TeamMapper {

    TeamEntity toEntity(TeamRequest teamRequest);

    ProjectEntity toEntity(ProjectRequest projectRequest);

    ManagerEntity toEntity(ManagerRequest managerRequest);





    TeamResponse toDTO(TeamEntity teamRequest);

    ProjectResponse toDTO(ProjectEntity projectRequest);

    ManagerResponse toDTO(ManagerEntity managerRequest);
}
