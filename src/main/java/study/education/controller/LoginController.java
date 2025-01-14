package study.education.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import study.education.entity.User;
import study.education.service.LoginService;

@RestController
@RequestMapping("/api/users")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/register")
	public String register(@RequestBody User user) {
		loginService.register(user);
		return "User registered successfully!";
	}

	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password) {
		User user = loginService.login(email, password);
		if (user != null) {
			return "Login successful!";
		} else {
			return "Invalid email or password!";
		}
	}
}
