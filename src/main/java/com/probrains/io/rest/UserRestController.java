package com.probrains.io.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.probrains.io.entity.UserDetails;
import com.probrains.io.entity.UserResponse;
import com.probrains.io.service.UserService;

@RestController
@RequestMapping("/userapi")
public class UserRestController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<UserDetails> getListOfCustomers() {
		return userService.getUsers();
	}
	
	@GetMapping("/users/{userId}")
	public UserResponse<UserDetails> getUserById(@PathVariable int userId) {
		UserDetails theUserDetails = userService.getUser(userId);
		UserResponse<UserDetails> theUserResponse = null;
		if (theUserDetails == null) {
			String message = "User id not found: " + userId;
			theUserResponse = new UserResponse<UserDetails>(HttpStatus.NOT_FOUND.value(), true, System.currentTimeMillis(), message,
					null);
		} else {
			theUserResponse = new UserResponse<UserDetails>(HttpStatus.OK.value(), false, System.currentTimeMillis(), "Success",
					theUserDetails);
		}
		return theUserResponse;
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
	public UserResponse<UserDetails> deleteUser(@PathVariable int userId) {
		UserDetails theUserDetails = userService.getUser(userId);
		UserResponse<UserDetails> theUserResponse = null;
		if (theUserDetails == null) {
			String message = "User id not found: " + userId;
			theUserResponse = new UserResponse<UserDetails>(HttpStatus.NOT_FOUND.value(), true, System.currentTimeMillis(), message,
					null);
		} else {
			userService.delete(userId);
			String message = "Delete user id is : " + userId;
			theUserResponse = new UserResponse<UserDetails>(HttpStatus.OK.value(), false, System.currentTimeMillis(), message, null);
		}

		return theUserResponse;
	}
}
