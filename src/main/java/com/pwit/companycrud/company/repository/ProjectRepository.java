package com.pwit.companycrud.company.repository;

import com.pwit.companycrud.company.repository.model.ProjectEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectRepository extends PagingAndSortingRepository<ProjectEntity, UUID>, CrudRepository<ProjectEntity, UUID> {


}
