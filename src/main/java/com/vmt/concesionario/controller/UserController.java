package com.vmt.concesionario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vmt.concesionario.exception.NotFoundException;
import com.vmt.concesionario.model.User;
import com.vmt.concesionario.model.UserDTO;
import com.vmt.concesionario.service.UserService;
import com.vmt.concesionario.service.mapper.UserMapper;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping
	Page<UserDTO> findAll(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
		final Pageable pagination = PageRequest.of(page, size);
		final Page<User> pageUser = userService.findAll(pagination); 
		return userMapper.mapEntityPageToDtoPage(pageUser);
	}
	
	@GetMapping("/{id}")
	UserDTO findOne(@PathVariable String id) throws NotFoundException {
		final User user = userService.findOne(id).orElseThrow(() -> new NotFoundException("User not found"));
		return userMapper.mapEntityToDto(user);
	}
	
	@PostMapping
	UserDTO create(@RequestBody UserDTO userDTO) {
		final User user = userMapper.mapDtoToEntity(userDTO);
		final User userCreated = userService.create(user);
		return userMapper.mapEntityToDto(userCreated);
	}
	
	@PutMapping("/{id}")
	UserDTO update(@PathVariable String id, @RequestBody UserDTO userDTO) throws NotFoundException {
		final User user = userMapper.mapDtoToEntity(userDTO);
		final User userUpdated = userService.update(id, user);
		return userMapper.mapEntityToDto(userUpdated);
	}
	
	@DeleteMapping("/{id}")
	void delete(@PathVariable String id) {
		userService.deleteById(id);
	}
}
