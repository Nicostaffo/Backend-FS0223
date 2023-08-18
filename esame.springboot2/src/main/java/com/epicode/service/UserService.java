package com.epicode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import com.epicode.classes.User;
import com.epicode.repository.IUserPaginazioneRepo;
import com.epicode.repository.IUserRepo;
import com.epicode.springboot2.security.exception.MyAPIException;

public class UserService {

	
	@Autowired IUserRepo userRepo;
	@Autowired IUserPaginazioneRepo userPagRepo;
	public User getById(Long id) {
		if(userRepo.existsById(id))
		         return userRepo.findById(id).get();
		else
			     throw new MyAPIException(HttpStatus.BAD_REQUEST, "Utente non trovato");
	}
    public Page<User> getUsersPagination(Pageable page){
    	return (Page<User>) userRepo.findAll();
    }
    public void deleteById(Long id) {
    	if(userRepo.existsById(id)) {
    		userRepo.deleteById(id);
    	}
          else {
    	throw new MyAPIException(HttpStatus.BAD_REQUEST, "Utente non trovato");
    }
   }

  }
