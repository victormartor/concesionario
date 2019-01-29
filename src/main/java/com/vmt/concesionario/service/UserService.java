package com.vmt.concesionario.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vmt.concesionario.exception.NotFoundException;
import com.vmt.concesionario.model.User;


public interface UserService {

	Page<User> findAll(Pageable pagination);
	
	Optional<User> findOne(String id);
	
	User create(User user);
	
	User update(String id, User user) throws NotFoundException;
	
	void deleteById(String id);
}
