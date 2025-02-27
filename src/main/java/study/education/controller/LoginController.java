package study.education.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import study.education.dto.SignUpRequestDto;
import study.education.service.LoginService;

@Controller
public class LoginController {

	private final LoginService loginService;

	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@GetMapping({"/"})
	public ModelAndView getMainPage() {
		return new ModelAndView("/index");
	}

	@GetMapping({"/login"})
	public ModelAndView getLogin() {
        return new ModelAndView("/account/login");
	}

	@PostMapping("/signup")
	@ResponseBody
	public ResponseEntity<String> signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
		loginService.registerUser(signUpRequestDto);
		return ResponseEntity.ok("회원가입 성공!");
	}
}
