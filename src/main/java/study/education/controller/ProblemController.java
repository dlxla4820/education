package study.education.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import study.education.dto.ProblemDto;
import study.education.dto.ResponseDto;
import study.education.service.ProblemService;

@Controller
@RequiredArgsConstructor
public class ProblemController {
    private final ProblemService problemService;

    @PostMapping("/problem")
    @ResponseBody
    public ResponseEntity<?> saveQuiz(@RequestBody ProblemDto requestBody) {
        ResponseDto<?> response = problemService.saveProblem(requestBody);
        return new ResponseEntity<>(response.getData(), HttpStatus.valueOf(response.getCode()));
    }

    @GetMapping("/problem")
    public ModelAndView getProblemList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/problem/index");
        return mv;
    }

    @GetMapping("/problem/{problemId}")
    public ModelAndView getProblem(@PathVariable long problemId) {
        ModelAndView mv = new ModelAndView();
        ProblemDto problemDto = problemService.getProblemDtoById(problemId);
        mv.addObject("problem", problemDto);
        mv.setViewName("/problem/index");
        return mv;
    }

}
