package com.pwit.companycrud.company.controller.mapper;

import com.pwit.companycrud.company.controller.dto.request.DepartmentRequest;
import com.pwit.companycrud.company.controller.dto.response.DepartmentResponse;
import com.pwit.companycrud.company.repository.model.DepartmentEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = TeamMapper.class, injectionStrategy = CONSTRUCTOR)
public interface DepartmentMapper {

    DepartmentEntity toEntity(DepartmentRequest departmentRequest);

    DepartmentResponse toDTO(DepartmentEntity departmentRequest);
}
