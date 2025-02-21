package com.antonny.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antonny.demo.entity.PerfilEntity;

public interface PerfilRepository extends JpaRepository<PerfilEntity,Long> {

}
