package com.antonny.demo.dto;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import com.antonny.demo.entity.PermissaoPerfilRecursoEntity;


public class PermissaoPerfilRecursoDTO {
	
	private Long id;
	
	private PerfilDTO perfil;
	
	private RecursoDTO recurso;
	
	public PermissaoPerfilRecursoDTO() {
		
	}
	
	public PermissaoPerfilRecursoDTO(PermissaoPerfilRecursoEntity permissaoPerfilRecurso) {
		BeanUtils.copyProperties(permissaoPerfilRecurso, this);
		if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getRecurso() != null) {
			this.recurso = new RecursoDTO(permissaoPerfilRecurso.getRecurso());
		}
		
		if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getPerfil() != null) {
			this.perfil = new PerfilDTO(permissaoPerfilRecurso.getPerfil());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PerfilDTO getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilDTO perfil) {
		this.perfil = perfil;
	}

	public RecursoDTO getRecurso() {
		return recurso;
	}

	public void setRecurso(RecursoDTO recurso) {
		this.recurso = recurso;
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
		PermissaoPerfilRecursoDTO other = (PermissaoPerfilRecursoDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
