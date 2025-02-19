package com.antonny.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.antonny.demo.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}
