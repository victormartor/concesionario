package com.vmt.concesionario.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vmt.concesionario.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
