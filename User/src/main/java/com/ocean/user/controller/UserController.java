package com.ocean.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocean.user.awthrequest.AuthRequest;
import com.ocean.user.entity.User;
import com.ocean.user.exception.UserNotFoundException;
import com.ocean.user.jwt.JwtUtil;
import com.ocean.user.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private IUserService iUserService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return iUserService.addUser(user);
	}

	@PutMapping("/update/{userEmail}")
	public User updateUser(@RequestBody User user, @PathVariable String userEmail) {
		return iUserService.updateUser(user, userEmail);
	}

	@GetMapping("/getAll")
	public List<User> getAllUSer() {
		return iUserService.getAllUser();
	}

	@GetMapping("/getByEmail/{userEmail}")
	public User getUserByEmail(@PathVariable String userEmail) {
		return iUserService.getUserByEmail(userEmail);
	}

	@DeleteMapping("/delete/{userEmail}")
	public void deleteUser(@PathVariable String userEmail) {
		iUserService.deleteUser(userEmail);
	}
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserEmail(), authRequest.getUserPassword()));
		} catch (Exception e) {
			throw new Exception("Invalid Username or Password.");
		}
		return jwtUtil.generateToken(authRequest.getUserEmail());
	}

	@GetMapping("/login/{userEmail}/{userPassword}")
//	@PreAuthorize("hasAnyRole('OWNER','MANAGER','RECEPTIONIST')")
	public ResponseEntity<?> Login(@PathVariable String userEmail, @PathVariable String userPassword)
			throws UserNotFoundException {
		User user = iUserService.logIn(userEmail, userPassword);
		return new ResponseEntity<>(user, HttpStatus.OK);

	}

}
