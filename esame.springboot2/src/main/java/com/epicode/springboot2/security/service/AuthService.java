package com.epicode.springboot2.security.service;

import com.epicode.springboot2.security.payload.LoginDto;
import com.epicode.springboot2.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
