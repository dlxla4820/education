package study.education.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.education.dto.SignUpRequestDto;
import study.education.service.LoginService;

@RestController
@RequestMapping("/api")
public class LoginController {

	private final LoginService loginService;

	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
		loginService.registerUser(signUpRequestDto);
		return ResponseEntity.ok("회원가입 성공!");
	}
}
