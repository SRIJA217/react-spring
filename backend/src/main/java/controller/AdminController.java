package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.User;
import service.IUserService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("api/admin")
public class AdminController {
	@Autowired
    private IUserService userService;
	@GetMapping("all")
	public ResponseEntity<?> getAllUSers()
	{
		return ResponseEntity.ok(userService.findAllUsers());
	}
	@DeleteMapping("userId")
	public ResponseEntity<?> deleteUser(@PathVariable Long userId)
	{
		User user=userService.deleteUser(userId);
		return ResponseEntity.ok(user);
	}
}
