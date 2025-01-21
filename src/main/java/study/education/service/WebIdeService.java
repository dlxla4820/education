package study.education.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.education.dto.CodeRunRequestDto;
import study.education.dto.ResponseDto;
import study.education.repository.QuizRepository;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class WebIdeService{

    private final QuizRepository quizRepository;

//    public ResponseDto<?> codeRun(UUID quizUuid, CodeRunRequestDto requestBody){
//
//    }

}
