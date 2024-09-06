package com.pwit.companycrud.company.controller.mapper;

import com.pwit.companycrud.company.controller.dto.request.TeamRequest;
import com.pwit.companycrud.company.controller.dto.response.TeamResponse;
import com.pwit.companycrud.company.repository.model.TeamEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = ProjectMapper.class, injectionStrategy = CONSTRUCTOR)
public interface TeamMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    TeamEntity toEntity(TeamRequest teamRequest);

    TeamResponse toDTO(TeamEntity teamRequest);
}
