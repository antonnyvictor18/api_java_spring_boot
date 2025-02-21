package com.antonny.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antonny.demo.entity.PerfilUsuarioEntity;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuarioEntity, Long> {

}
