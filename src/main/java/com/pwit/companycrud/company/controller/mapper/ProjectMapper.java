package com.pwit.companycrud.company.controller.mapper;

import com.pwit.companycrud.company.controller.dto.request.ProjectRequest;
import com.pwit.companycrud.company.controller.dto.response.ProjectResponse;
import com.pwit.companycrud.company.repository.model.ProjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = ManagerMapper.class, injectionStrategy = CONSTRUCTOR)
public interface ProjectMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    ProjectEntity toEntity(ProjectRequest projectRequest);

    ProjectResponse toDTO(ProjectEntity projectRequest);
}
