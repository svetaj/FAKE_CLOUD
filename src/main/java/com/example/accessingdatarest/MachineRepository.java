package com.example.accessingdatarest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "machines", path = "machines")
public interface MachineRepository extends PagingAndSortingRepository<Machine, Long> {

  List<Machine> findByUid(@Param("uid") String uid);

}
