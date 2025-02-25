package com.antonny.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.antonny.demo.Security.jwt.JwtUtils;
import com.antonny.demo.dto.AcessDTO;
import com.antonny.demo.dto.AuthenticationDTO;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Autowired
    public AuthService(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    public AcessDTO login(AuthenticationDTO authDTO) throws Exception {
        try {
            UsernamePasswordAuthenticationToken userAuth =
                    new UsernamePasswordAuthenticationToken(authDTO.getUsername(), authDTO.getPassword());

            Authentication authentication = authenticationManager.authenticate(userAuth);
            UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();

            String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

            return new AcessDTO(token);

        } catch (BadCredentialsException e) {
            return new AcessDTO("Acesso Negado");
        }
    }
}
