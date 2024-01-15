package com.ocean.user.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ocean.user.entity.User;
import com.ocean.user.exception.UserNotFoundException;
import com.ocean.user.repository.UserRepository;

@Service
public class UserService implements IUserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) throws UserNotFoundException {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user, String userEmail) throws UserNotFoundException {
		User existingUser = userRepository.findById(user.getUserEmail())
				.orElseThrow(() -> new UserNotFoundException("User not found..."));
		existingUser.setUserName(user.getUserName());
		existingUser.setUserRole(user.getUserRole());
		existingUser.setUserPassword(user.getUserPassword());

		return userRepository.save(existingUser);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUserByEmail(String userEmail) throws UserNotFoundException {
		try {
			return userRepository.findById(userEmail).get();
		} catch (Exception e) {
			throw new UserNotFoundException("User not found");
		}
	}

	@Override
	public void deleteUser(String userEmail) throws UserNotFoundException {
		userRepository.findById(userEmail).orElseThrow(() -> new UserNotFoundException("User not found"));
		userRepository.deleteById(userEmail);
	}

    //Security
	@Override
	public User logIn(String userEmail, String userPassword) throws UserNotFoundException {
		User userObj= userRepository.findById(userEmail)
				.orElseThrow(() -> new UserNotFoundException("Staff not found"));

				if (!userObj.getUserPassword().equals(userPassword)) {
					throw new RuntimeException("Invalid password or username");
				}
				return userObj;
	}

    @Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		User user = userRepository.findById(userEmail).get();
		return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getUserPassword(),
				Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getUserRole().toString())));
	}

}
