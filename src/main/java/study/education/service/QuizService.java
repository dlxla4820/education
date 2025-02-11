package study.education.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.education.dto.QuizRequestDto;
import study.education.dto.ResponseDto;
import study.education.entity.Quiz;
import study.education.repository.QuizRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;

    public ResponseDto<?> saveQuiz(QuizRequestDto requestBody){
        // Todo : 인증
        // Todo : 유효성 검증
        quizRepository.save(requestBody.toQuizEntity());
        return ResponseDto.builder()
                .code(200)
                .data("success")
                .build();
    }
}
