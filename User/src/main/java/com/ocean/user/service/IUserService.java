package com.ocean.user.service;

import java.util.List;
import com.ocean.user.entity.User;
import com.ocean.user.exception.UserNotFoundException;

public interface IUserService {

	public User addUser(User user) throws UserNotFoundException;

	public User updateUser(User user, String userEmail) throws UserNotFoundException;

	public List<User> getAllUser();

	public User getUserByEmail(String userEmail) throws UserNotFoundException;

	public void deleteUser(String userEmail) throws UserNotFoundException;
	
	public User logIn(String userEmail, String userPassword) throws UserNotFoundException;

}
