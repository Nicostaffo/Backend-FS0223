package com.epicode.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.epicode.springboot2.security.entity.ERole;
import com.epicode.springboot2.security.entity.Role;

public interface IRoleRepo extends CrudRepository<Role, Long> {
     Optional<Role> findByRoleName(ERole roleName);
}
