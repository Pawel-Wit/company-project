package com.pwit.companycrud.company.controller.mapper;

import com.pwit.companycrud.company.controller.dto.request.CompanyRequest;
import com.pwit.companycrud.company.controller.dto.response.CompanyResponse;
import com.pwit.companycrud.company.repository.model.CompanyEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = DepartmentMapper.class, injectionStrategy = CONSTRUCTOR)
public interface CompanyMapper {

    CompanyEntity toEntity(CompanyRequest companyRequest);

    CompanyResponse toDTO(CompanyEntity entity);


}
