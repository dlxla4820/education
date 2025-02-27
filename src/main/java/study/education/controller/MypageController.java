package study.education.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MypageController {

	@GetMapping({"/mypage"})
	public ResponseEntity<String> myPage(HttpSession session) {
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
		}
		return ResponseEntity.ok(username + "님의 마이페이지입니다.");
	}
}
