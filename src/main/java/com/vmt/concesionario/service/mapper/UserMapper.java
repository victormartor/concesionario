package com.vmt.concesionario.service.mapper;

import org.springframework.data.domain.Page;

import com.vmt.concesionario.model.User;
import com.vmt.concesionario.model.UserDTO;

public interface UserMapper {

	UserDTO mapEntityToDto(User user);
	
	User mapDtoToEntity(UserDTO userDTO);
	
	Page<UserDTO> mapEntityPageToDtoPage(Page<User> pageUser);
	
}
