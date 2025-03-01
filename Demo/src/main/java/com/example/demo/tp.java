package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tp {

	@Autowired
	TpRepo repo;

	@GetMapping("/status")

	public String checkStatus() {
		return "Spring Boot application is running!";
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		List<User> allUsers = repo.findAll();
		return allUsers;
	}

	@RequestMapping("/user/{uid}")
	public Optional<User> getById(@PathVariable("uid") int uid) {
		Optional<User> u = repo.findById(uid);
		return u;
	}

	@PostMapping("/user")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		try {
			User savedUser = repo.save(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
		}
	}

	@PutMapping("/user/{uid}")
	public ResponseEntity<User> updateOrSave(@PathVariable int uid, @RequestBody User user) {
		Optional<User> existingUser = repo.findById(uid);
		if (existingUser.isPresent()) {
			User updateUser = existingUser.get();
			updateUser.setCity(user.getCity());
			updateUser.setUname(user.getUname());

			User updatesUser = repo.save(updateUser);
			return ResponseEntity.ok(updatesUser);
		}
		User newUser = repo.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(newUser);

	}

	@DeleteMapping("/user/{uid}")
	public ResponseEntity<String> deleteById(@PathVariable int uid) {
		Optional<User> user = repo.findById(uid);
		if(user.isPresent()) {
			repo.deleteById(uid);
			return ResponseEntity.ok("Deleted");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
	}
}
