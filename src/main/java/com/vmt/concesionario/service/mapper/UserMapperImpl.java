package com.vmt.concesionario.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.vmt.concesionario.model.User;
import com.vmt.concesionario.model.UserDTO;

@Service
public class UserMapperImpl implements UserMapper{

	@Autowired
	private ModelMapper mapper;
	
	@Override
	public UserDTO mapEntityToDto(User user) {
		return mapper.map(user, UserDTO.class);
	}

	@Override
	public User mapDtoToEntity(UserDTO userDTO) {
		return mapper.map(userDTO, User.class);
	}

	@Override
	public Page<UserDTO> mapEntityPageToDtoPage(Page<User> pageUser) {
		return pageUser.map(this::mapEntityToDto);
	}

}
