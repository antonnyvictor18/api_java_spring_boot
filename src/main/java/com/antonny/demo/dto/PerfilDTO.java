package com.antonny.demo.dto;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.antonny.demo.entity.PerfilEntity;

public class PerfilDTO {
	
	private Long id;
	
	private String descricao;

	public PerfilDTO() {
		
	}
	
	public PerfilDTO(PerfilEntity perfil) {
		BeanUtils.copyProperties(perfil, this);
	}
	
	public Long getId() {
		return id;
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
		PerfilDTO other = (PerfilDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
