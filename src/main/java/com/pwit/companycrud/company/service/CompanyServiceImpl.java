package com.pwit.companycrud.company.service;


import com.pwit.companycrud.company.repository.CompanyRepository;
import com.pwit.companycrud.company.repository.model.CompanyEntity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Transactional
@Component
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    public static final String SORTING_COLUMN_NAME = "name";

    private final CompanyRepository repository;

    @Override
    public CompanyEntity save(CompanyEntity entity) {
        log.info("Saving new company with name: {}", entity.getName());
        CompanyEntity company = repository.save(entity);
        log.info("Company saved, id: {}", company.getId());
        return company;
    }

    @Override
    public CompanyEntity getById(UUID id) {
        log.info("Fetching company by id: {}", id);
        CompanyEntity company = getCompanyById(id);
        log.info("Company fetched with id: {}, name: {}", company.getId(), company.getName());
        return company;
    }

    @Override
    public Page<CompanyEntity> page(Integer pageNumber, Integer pageSize) {
        log.info("Fetching companies page: number = {}, size = {}", pageNumber, pageSize);
        Page<CompanyEntity> companies = repository.findAll(
                PageRequest.of(pageNumber, pageSize, Sort.by(SORTING_COLUMN_NAME)));
        log.info("Fetched {} companies", companies.getTotalElements());
        return companies;
    }

    @Override
    public CompanyEntity update(UUID id, CompanyEntity updatedCompany) {
        log.info("Updating company with id: {}", id);
        CompanyEntity company = getCompanyById(id);
        company.setName(updatedCompany.getName());
        company.setDepartments(updatedCompany.getDepartments());
        log.info("Company updated successfully, id: {}", id);
        return company;
    }

    @Override
    public void delete(UUID id) {
        log.info("Deleting company with id: {}", id);
        repository.deleteById(id);
        log.info("Company with id {} deleted", id);
    }

    private CompanyEntity getCompanyById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Company with id: %s doesn't exist".formatted(id)));
    }
}
