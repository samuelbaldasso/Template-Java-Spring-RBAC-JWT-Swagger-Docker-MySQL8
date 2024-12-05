package com.sbaldasso.combo.controllers;

import com.sbaldasso.combo.domains.User;
import com.sbaldasso.combo.dto.JWTToken;
import com.sbaldasso.combo.dto.UserDTO;
import com.sbaldasso.combo.security.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtils jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<JWTToken> login(@RequestBody UserDTO userDTO) throws BadCredentialsException {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getEmail(), userDTO.getPassword()));
        String email = authentication.getName();
        String token = jwtUtil.generateToken(email);
        JWTToken loginRes = new JWTToken(email, token);

        return ResponseEntity.ok(loginRes);
    }
}