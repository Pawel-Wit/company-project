package com.pwit.companycrud.company.service;

import com.pwit.companycrud.company.repository.model.CompanyEntity;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface CompanyService {

    CompanyEntity save(CompanyEntity entity);

    CompanyEntity getById(UUID id);

    Page<CompanyEntity> page(Integer pageNumber, Integer pageSize);

    CompanyEntity update(UUID id, CompanyEntity updatedCompany);

    void delete(UUID id);
}
