package com.marsdeployment.marscrudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marsdeployment.marscrudapp.model.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
