package com.pwit.companycrud.company.controller.mapper;

import com.pwit.companycrud.company.controller.dto.request.ManagerRequest;
import com.pwit.companycrud.company.controller.dto.response.ManagerResponse;
import com.pwit.companycrud.company.repository.model.ManagerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, injectionStrategy = CONSTRUCTOR)
public interface ManagerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    ManagerEntity toEntity(ManagerRequest managerRequest);

    ManagerResponse toDTO(ManagerEntity managerRequest);
}
