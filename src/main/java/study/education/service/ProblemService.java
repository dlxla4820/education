package study.education.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.education.dto.ProblemDto;
import study.education.dto.ResponseDto;
import study.education.entity.Problem;
import study.education.exception.ModelNotFoundException;
import study.education.repository.ProblemRepository;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ProblemService {
    private final ProblemRepository problemRepository;

    public ResponseDto<?> saveProblem(ProblemDto requestBody){
        // Todo : 인증
        // Todo : 유효성 검증
        UUID userUuid = UUID.randomUUID(); // Todo : 유저 인증 이후
        problemRepository.save(requestBody.toProblemEntity(userUuid));
        return ResponseDto.builder()
                .code(200)
                .data("success")
                .build();
    }


    public ProblemDto getProblemDtoById(Long problemId){
        Problem problem = problemRepository.findById(problemId).orElseThrow(() -> new ModelNotFoundException("Problem Not Found"));
        return ProblemDto.fromProblemEntity(problem);
    }
}
