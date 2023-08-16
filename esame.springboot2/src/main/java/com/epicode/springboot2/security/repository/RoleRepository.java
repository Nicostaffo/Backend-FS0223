package com.epicode.springboot2.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.springboot2.security.entity.ERole;
import com.epicode.springboot2.security.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
