package study.education.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import study.education.dto.QuizRequestDto;
import study.education.dto.ResponseDto;
import study.education.service.QuizService;

@Controller
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @PostMapping("/quiz")
    @ResponseBody
    public ResponseEntity<?> saveQuiz(@RequestBody QuizRequestDto requestBody) {
        ResponseDto<?> response = quizService.saveQuiz(requestBody);
        return new ResponseEntity<>(response.getData(), HttpStatus.valueOf(response.getCode()));
    }

}
