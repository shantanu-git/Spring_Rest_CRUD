package com.probrains.io.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.probrains.io.entity.UserDetails;
import com.probrains.io.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<UserDetails> getListOfCustomers() {
		return userService.getUsers();
	}

	@GetMapping("/users/{userId}")
	public UserDetails getUserById(@PathVariable int userId) {
		UserDetails theUserDetails = userService.getUser(userId);
		if (theUserDetails == null) {
			throw new UserNotFoundException("User id not found: " + userId);
		}
		return theUserDetails;
	}

	@PostMapping("/users")
	public UserDetails addUser(@RequestBody UserDetails theUser) {
		userService.saveUser(theUser);
		return theUser;
	}

	@PutMapping("/users")
	public UserDetails updateUser(@RequestBody UserDetails theUser) {
		userService.saveUser(theUser);
		return theUser;
	}

	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable int userId) {
		UserDetails theUserDetails = userService.getUser(userId);

		if (theUserDetails == null) {
			throw new UserNotFoundException("User id not found: " + userId);
		}
		userService.delete(userId);
		return "Delete user id is : " + userId;
	}
}
