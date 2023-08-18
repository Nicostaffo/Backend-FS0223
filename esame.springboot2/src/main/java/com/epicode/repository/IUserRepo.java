package com.epicode.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.epicode.classes.User;

public interface IUserRepo extends CrudRepository<User, Long> {
  Optional<User> FindByEmail(String email);
  Optional<User> FindByUsername(String username);
  Optional<User> FindByUsernameOrEmail(String email, String username);
  
  Boolean existsByUsername(String username);
  Boolean existsByEmail(String email);
 
}
