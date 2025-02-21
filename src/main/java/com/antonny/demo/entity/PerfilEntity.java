package com.antonny.demo.entity;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.antonny.demo.dto.PerfilDTO;
import com.antonny.demo.dto.RecursoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AV_PERFIL")
public class PerfilEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String descricao;

	public Long getId() {
		return id;
	}
	
	public PerfilEntity() {
		
	}
	
	public PerfilEntity(PerfilDTO perfil) {
		BeanUtils.copyProperties(perfil, this);
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PerfilEntity other = (PerfilEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
