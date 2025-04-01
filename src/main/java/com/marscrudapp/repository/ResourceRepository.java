package com.marscrudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marscrudapp.model.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
