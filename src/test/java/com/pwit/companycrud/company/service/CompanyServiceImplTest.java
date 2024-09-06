package com.pwit.companycrud.company.service;

import com.pwit.companycrud.company.repository.CompanyRepository;
import com.pwit.companycrud.company.repository.model.*;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.Collections.singletonList;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CompanyServiceImplTest {

    private static final UUID COMPANY_ID = UUID.randomUUID();
    private static final String COMPANY_NAME = "Samsung";
    private static final String DEPARTMENT_NAME = "Research and Development";
    private static final String TEAM_NAME = "Team M";
    private static final String PROJECT_NAME = "Project N";
    private static final String EMAIL = "Jan.Kowalski@gmail.com";
    private static final String PHONE_NUMBER = "+48600500333";

    private final CompanyRepository repository = mock(CompanyRepository.class);

    private final CompanyService service = new CompanyServiceImpl(repository);

    @Test
    void shouldSaveCompany() {
        //given
        CompanyEntity company = buildCompanyEntity();
        when(repository.save(company)).thenReturn(company);

        //when
        CompanyEntity result = service.save(company);

        //then
        verify(repository).save(company);
        assertEquals(company, result);
    }

    @Test
    void shouldReturnCompany() {
        //given
        CompanyEntity company = buildCompanyEntity();
        when(repository.findById(COMPANY_ID)).thenReturn(Optional.ofNullable(company));

        //when
        CompanyEntity result = service.getById(COMPANY_ID);

        //then
        verify(repository).findById(COMPANY_ID);
        assertEquals(company, result);
    }

    @Test
    void shouldReturnCompaniesPage() {
        //given
        int pageNumber = 0;
        int pageSize = 10;
        String sortingColumn = "name";
        CompanyEntity company = buildCompanyEntity();
        Page<CompanyEntity> page = new PageImpl<>(singletonList(company));
        when(repository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortingColumn)))).thenReturn(page);

        //when
        Page<CompanyEntity> result = service.page(pageNumber, pageSize);

        //then
        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        assertEquals(company, result.getContent().getFirst());
        verify(repository).findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortingColumn)));
    }

    @Test
    void shouldUpdateCompany() {
        //given
        CompanyEntity company = buildCompanyEntity();
        when(repository.findById(COMPANY_ID)).thenReturn(Optional.ofNullable(company));

        //when
        CompanyEntity result = service.update(COMPANY_ID, company);

        //then
        verify(repository).findById(COMPANY_ID);
        assertEquals(company, result);
    }

    @Test
    void shouldDeleteCompany() {
        //when
        service.delete(COMPANY_ID);

        //then
        verify(repository).deleteById(COMPANY_ID);
    }

    @Test
    void shouldThrowWhenCompanyNotFound() {
        //given
        UUID companyId = UUID.randomUUID();
        when(repository.findById(companyId)).thenReturn(Optional.empty());

        //when
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,
                () -> service.getById(companyId)
        );

        //then
        assertEquals("Company with id: %s doesn't exist".formatted(companyId), exception.getMessage());
        verify(repository).findById(companyId);
    }

    private CompanyEntity buildCompanyEntity() {
        return CompanyEntity.builder()
                .id(COMPANY_ID)
                .name(COMPANY_NAME)
                .departments(List.of(buildDepartmentEntity()))
                .build();
    }

    private DepartmentEntity buildDepartmentEntity() {
        return DepartmentEntity.builder()
                .id(COMPANY_ID)
                .name(DEPARTMENT_NAME)
                .teams(List.of(buildTeamEntity()))
                .build();

    }

    private TeamEntity buildTeamEntity() {
        return TeamEntity.builder()
                .id(COMPANY_ID)
                .name(TEAM_NAME)
                .project(buildProjectEntity())
                .build();

    }

    private ProjectEntity buildProjectEntity() {
        return ProjectEntity.builder()
                .id(COMPANY_ID)
                .name(PROJECT_NAME)
                .manager(buildManagerEntity())
                .build();

    }

    private ManagerEntity buildManagerEntity() {
        return ManagerEntity.builder()
                .id(COMPANY_ID)
                .name(COMPANY_NAME)
                .email(EMAIL)
                .phoneNumber(PHONE_NUMBER)
                .build();
    }
}