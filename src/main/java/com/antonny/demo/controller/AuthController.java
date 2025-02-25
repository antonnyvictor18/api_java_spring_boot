package com.antonny.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonny.demo.dto.AuthenticationDTO;
import com.antonny.demo.dto.UsuarioDTO;
import com.antonny.demo.service.AuthService;
import com.antonny.demo.service.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationDTO authDTO) throws Exception{
		return ResponseEntity.ok(authService.login(authDTO));
		
	};
	
	@PostMapping(value = "/novoUsuario")
	public void inserirNovoUsuario(@RequestBody UsuarioDTO novoUsuario){
		
		usuarioService.inserirNovoUsuario(novoUsuario);
		
	}
	
	@GetMapping(value = "/verificarCadastro/{uuid}")
	public String verificarCadastro(@PathVariable("uuid") String uuid) {
		return usuarioService.verificarCadastro(uuid);
	}
	
}
