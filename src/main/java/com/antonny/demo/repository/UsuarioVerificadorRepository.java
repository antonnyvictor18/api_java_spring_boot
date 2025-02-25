package com.antonny.demo.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antonny.demo.entity.UsuarioVerificadorEntity;

public interface UsuarioVerificadorRepository extends JpaRepository<UsuarioVerificadorEntity, Long>{

	public Optional<UsuarioVerificadorEntity> findByUuid(UUID uuid);
}
