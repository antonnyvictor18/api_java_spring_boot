package com.antonny.demo.dto;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.antonny.demo.entity.RecursoEntity;



public class RecursoDTO {
	
	private long id;

	private String nome;

	private String chave;
	
	public RecursoDTO() {
		
	}
	    
	public RecursoDTO(RecursoEntity recurso) {
		BeanUtils.copyProperties(recurso, this);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
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
		RecursoDTO other = (RecursoDTO) obj;
		return id == other.id;
	}
	
	

}
