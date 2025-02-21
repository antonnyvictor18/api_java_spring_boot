package com.antonny.demo.dto;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.antonny.demo.entity.PerfilUsuarioEntity;

public class PerfilUsuarioDTO {
	
	private Long id;
	private UsuarioDTO usuario;
	private PerfilDTO perfil;
	
	public PerfilUsuarioDTO() {
		
	}
	
	public PerfilUsuarioDTO(PerfilUsuarioEntity perfilUsuario) {
		BeanUtils.copyProperties(perfilUsuario, this);
		if(perfilUsuario != null && perfilUsuario.getUsuario() != null) {
			this.usuario = new UsuarioDTO(perfilUsuario.getUsuario());
		}
		
		if(perfilUsuario != null && perfilUsuario.getPerfil() != null) {
			this.perfil = new PerfilDTO(perfilUsuario.getPerfil());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public PerfilDTO getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilDTO perfil) {
		this.perfil = perfil;
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
		PerfilUsuarioDTO other = (PerfilUsuarioDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
