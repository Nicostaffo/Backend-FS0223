package com.epicode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.classes.Devices;
import com.epicode.classes.User;
import com.epicode.service.DevService;
import com.epicode.service.UserService;

@RestController
@RequestMapping("/api")
public class DevController {
  @Autowired DevService devSvc;
  @Autowired UserService userSvc;
  
  
  @DeleteMapping("/user/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<User> deleteUser(@PathVariable Long id){
	  User u = userSvc.getById(id);
	  userSvc.deleteById(id);
	  return ResponseEntity.ok(u);
	  
  }
  @DeleteMapping("/device/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<Devices> deleteDevice(@PathVariable Long id){
	  Devices de  = devSvc.getById(id);
	  userSvc.deleteById(id);
	  return ResponseEntity.ok(de);
	  
  }
  @PutMapping("/devices/dismesso/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> setDeviceDismesso(@PathVariable Long id){
	  Devices de = devSvc.dismissioneDevice(id);
	  return new ResponseEntity<Devices>(de, HttpStatus.OK);
	  
  }
  @GetMapping("/users")
  @PreAuthorize("hasRole('MODERATORE') or hasRole('ADMIN')")
  public ResponseEntity<Page<User>> getAllUsers(Pageable pageable){
	  Page<User> s = userSvc.getUsersPagination(pageable);
	  ResponseEntity<Page<User>> res = new ResponseEntity<Page<User>>(s, HttpStatus.OK);
	  return res;
	  
  }
  @GetMapping("/users/{id}")
  @PreAuthorize("hasRole('MODERATORE') or hasRole('ADMIN')")
  public ResponseEntity<?> getUserById(@PathVariable Long id){
	  User us = userSvc.getById(id);
	  ResponseEntity<User> res = new ResponseEntity<User>(us, HttpStatus.OK);
	  return res;
  }
  @GetMapping("/devices/nuovi")
  @PreAuthorize("hasRole('MODERATORE') or hasRole('ADMIN')")
  public ResponseEntity<?> aggiungiDevice(@RequestBody Devices de){
	  Devices d = devSvc.newDevice(de.getDeviceEnum(), de.getStatoEnum(), de.getModel(), de.getProduct());
	  ResponseEntity<Devices> res = new ResponseEntity<Devices>(d, HttpStatus.OK);
	  
	  return res;  
  }
  @PutMapping("/devices/smartphone/{id}")
  @PreAuthorize("hasRole('MODERATORE') or hasRole('ADMIN')")
  public ResponseEntity<?> aggiungiSmartphone(@PathVariable Long id,@RequestBody User us){
	  Devices dev = devSvc.assegnoDevice(id, us);
	
	return new ResponseEntity<Devices>(dev, HttpStatus.OK);
	  
  }
  @PutMapping("/devices/tablet/{id}")
  @PreAuthorize("hasRole('MODERATORE') or hasRole('ADMIN')")
  public ResponseEntity<?> aggiungiTablet(@PathVariable Long id,@RequestBody User us){
	  Devices dev = devSvc.assegnoDevice(id, us);
	  return new ResponseEntity<Devices>(dev, HttpStatus.OK);
	  
  }
  @PutMapping("/devices/laptop/{id}")
  @PreAuthorize("hasRole('MODERATORE') or hasRole('ADMIN')")
  public ResponseEntity<?> aggiungiLaptop(@PathVariable Long id,@RequestBody User us){
	  Devices dev = devSvc.assegnoDevice(id, us);
	  return new ResponseEntity<Devices>(dev, HttpStatus.OK);
	  
  }
  
  @PutMapping("/devices/manutenzione/{id}")
  @PreAuthorize("hasRole('MODERATORE') or hasRole('ADMIN')")
  public ResponseEntity<?> toggleDevice(@PathVariable Long id){
	  Devices dev = devSvc.toggleMaintenance(id);
	  return new ResponseEntity<Devices>(dev, HttpStatus.OK);
  }
  
  @GetMapping("/devices")
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<Page<Devices>>getAllDev(Pageable pageable){
	  Page<Devices> list = devSvc.getDevicesPaged(pageable);
	  ResponseEntity<Page<Devices>> res = new ResponseEntity<Page<Devices>>(list, HttpStatus.OK);
	  return res;
  }
  
  @GetMapping("/devices/{id}")
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<?> getDevById(@PathVariable Long id){
	  Devices dev = devSvc.getById(id);
	  ResponseEntity<Devices> res = new ResponseEntity<Devices>(dev, HttpStatus.OK);
	  return res;
  }
  
}
