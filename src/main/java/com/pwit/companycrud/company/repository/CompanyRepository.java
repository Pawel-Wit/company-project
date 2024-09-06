package com.pwit.companycrud.company.repository;

import com.pwit.companycrud.company.repository.model.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {


}
