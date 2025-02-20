package com.antonny.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antonny.demo.entity.RecursoEntity;


public interface RecursoRepository extends JpaRepository<RecursoEntity, Long> {
	

}
