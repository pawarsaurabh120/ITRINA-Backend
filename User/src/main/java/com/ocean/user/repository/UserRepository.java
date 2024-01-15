package com.ocean.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ocean.user.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
