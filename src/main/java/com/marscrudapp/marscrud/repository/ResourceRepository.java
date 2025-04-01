package com.marscrudapp.marscrud.repository;

import com.marscrudapp.marscrud.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
