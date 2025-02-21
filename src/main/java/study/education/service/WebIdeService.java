package study.education.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.education.repository.ProblemRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class WebIdeService{

    private final ProblemRepository problemRepository;

//    public ResponseDto<?> codeRun(UUID quizUuid, CodeRunRequestDto requestBody){
//
//    }

}
