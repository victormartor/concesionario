package com.vmt.concesionario.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vmt.concesionario.exception.NotFoundException;
import com.vmt.concesionario.model.User;
import com.vmt.concesionario.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Page<User> findAll(Pageable pagination) {
		return userRepository.findAll(pagination);
	}

	@Override
	public Optional<User> findOne(String id) {
		return userRepository.findById(id);
	}

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(String id, User user) throws NotFoundException {
		final User storedUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
		user.setId(id);
		mapper.map(user, storedUser);
		return userRepository.save(storedUser);
	}

	@Override
	public void deleteById(String id) {
		userRepository.deleteById(id);
	}

}
