package com.pwit.companycrud.company.controller;

import com.pwit.companycrud.company.controller.dto.request.CompanyRequest;
import com.pwit.companycrud.company.controller.dto.response.CompanyResponse;
import com.pwit.companycrud.company.controller.mapper.CompanyMapper;
import com.pwit.companycrud.company.repository.model.CompanyEntity;
import com.pwit.companycrud.company.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService service;
    private final CompanyMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyResponse create(@RequestBody @Valid CompanyRequest request) {
        CompanyEntity entity = mapper.toEntity(request);
        CompanyEntity savedCompany = service.save(entity);
        return mapper.toDTO(savedCompany);
    }

    @GetMapping("/{id}")
    public CompanyResponse getById(@PathVariable UUID id) {
        CompanyEntity company = service.getById(id);
        return mapper.toDTO(company);
    }

    @GetMapping
    public Page<CompanyResponse> page(@RequestParam Integer number,
                                      @RequestParam Integer size) {
        Page<CompanyEntity> companies = service.page(number, size);
        return companies.map(mapper::toDTO);
    }

    @PutMapping("/{id}")
    public CompanyResponse update(@PathVariable UUID id,@RequestBody @Valid CompanyEntity company) {
        CompanyEntity updatedCompany = service.update(id, company);
        return mapper.toDTO(updatedCompany);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
