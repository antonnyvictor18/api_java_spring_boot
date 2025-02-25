package com.antonny.demo.service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.antonny.demo.dto.UsuarioDTO;
import com.antonny.demo.entity.UsuarioEntity;
import com.antonny.demo.entity.UsuarioVerificadorEntity;
import com.antonny.demo.entity.enums.TipoSituacaoUsuario;
import com.antonny.demo.repository.UsuarioRepository;
import com.antonny.demo.repository.UsuarioVerificadorRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioVerificadorRepository usuarioVerificadorRepository;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@Autowired 
	private EmailService emailService;
	
	public List<UsuarioDTO> listarTodos() {
		List<UsuarioEntity> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(UsuarioDTO::new).toList();
	}
	
	public void inserir(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
		usuarioRepository.save(usuarioEntity);
	}
	
	public void inserirNovoUsuario(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
		usuarioEntity.setSituacao(TipoSituacaoUsuario.PENDENTE);
		usuarioRepository.save(usuarioEntity);
		
		UsuarioVerificadorEntity verificador = new UsuarioVerificadorEntity();
		verificador.setUsuario(usuarioEntity);
		verificador.setUuid(UUID.randomUUID());
		verificador.setDataExpiracao(Instant.now().plusMillis(900000));
		usuarioVerificadorRepository.save(verificador);
		
		emailService.enviarEmailTexto(usuario.getEmail(), 
				"Novo usuário cadastrado",
				"Você esta recebendo um email de cadastro de usuário. O número para validação é: "+ verificador.getUuid());
	}
	
	public String verificarCadastro(String uuid) {
		UsuarioVerificadorEntity usuarioVerificador = usuarioVerificadorRepository.findByUuid(UUID.fromString(uuid)).get();
		
		if(usuarioVerificador != null) {
			if(usuarioVerificador.getDataExpiracao().compareTo(Instant.now()) >= 0) {
				
				UsuarioEntity u = usuarioVerificador.getUsuario();
				u.setSituacao(TipoSituacaoUsuario.ATIVO);
				usuarioRepository.save(u);
				
				return "Usuário Verificado";
				
			} else {
				usuarioVerificadorRepository.delete(usuarioVerificador);
				return "Tempo de verificação expirado";
			}
		}
		else { 
			return "Usuario não verificado";
		}
	}
	
	public UsuarioDTO alterar(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
	}
	
	public void excluir(Long id) {
		UsuarioEntity usuario = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuario);
	}
	
	public UsuarioDTO buscarPorId(Long id) {
		return new UsuarioDTO(usuarioRepository.findById(id).get());
	}
}
