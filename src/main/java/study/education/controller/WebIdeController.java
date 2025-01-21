package study.education.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import study.education.dto.CodeRunRequestDto;
import study.education.dto.ResponseDto;
import study.education.service.WebIdeService;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class WebIdeController {
    private WebIdeService webIdeService;

    @PostMapping("/quiz/{quizUuId}/code")
    @ResponseBody
    public ResponseEntity<?> codeRun(@PathVariable UUID quizUuId, @RequestBody CodeRunRequestDto requestBody) {
        ResponseDto<?> response = webIdeService.codeRun(quizUuId, requestBody);
        return new ResponseEntity<>(response.getData(), HttpStatus.valueOf(response.getCode()));
    }

}
