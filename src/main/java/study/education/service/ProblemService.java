package study.education.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.education.dto.ErrorMessageDto;
import study.education.dto.ProblemDto;
import study.education.dto.ResponseDto;
import study.education.entity.Problem;
import study.education.enums.Description;
import study.education.exception.ModelNotFoundException;
import study.education.exception.UnprocessableException;
import study.education.repository.ProblemRepository;
import study.education.utils.CommonUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static study.education.enums.Error.*;
import static study.education.utils.CommonUtils.getErrorMapByError;
import static study.education.utils.Constant.*;

@Service
@Transactional
@RequiredArgsConstructor
public class ProblemService {
    private final ProblemRepository problemRepository;

    private final String problemModel = "Problem";

    public ResponseDto<?> saveProblem(ProblemDto requestBody){
        // Todo : 인증
        // Todo : 유효성 검증
        ErrorMessageDto<?> error = checkSaveProblem(requestBody);
        if(error != null)
            throw new UnprocessableException(error);
        UUID userUuid = UUID.randomUUID(); // Todo : 유저 인증 이후
        problemRepository.save(requestBody.toProblemEntity(userUuid));
        return ResponseDto.builder()
                .code(200)
                .data(Description.SUCCESS.getDescription())
                .build();
    }


    public ProblemDto getProblemDtoById(Long problemId){
        Problem problem = problemRepository.findById(problemId).orElseThrow(() -> new ModelNotFoundException(String.format(MODEL_NOT_FOUND_EXCEPTION, problemModel)));
        return ProblemDto.fromProblemEntity(problem);
    }


    private ErrorMessageDto<?> checkSaveProblem(ProblemDto requestBody) {
        // 초기 errorMap
        HashMap<String, List<String>> errorMap = new HashMap<>();

        // 각 조건에 따라 errorMap을 업데이트
        if (requestBody.getTitle() == null || requestBody.getTitle().isEmpty())
            errorMap = getErrorMapByError(errorMap, TITLE_IS_EMPTY);
        if (requestBody.getLevel() == null)
            errorMap = getErrorMapByError(errorMap, LEVEL_IS_EMPTY);
        if (requestBody.getLevel() != null && (requestBody.getLevel() < 1 || requestBody.getLevel() > 5))
            errorMap = getErrorMapByError(errorMap, LEVEL_IS_NOT_VALID);
        if (requestBody.getContent() == null || requestBody.getContent().isEmpty())
            errorMap = getErrorMapByError(errorMap, CONTENT_IS_EMPTY);
        if (requestBody.getInputCase() == null || requestBody.getInputCase().isEmpty())
            errorMap = getErrorMapByError(errorMap, INPUT_CASE_IS_EMPTY);
        if (requestBody.getOutputCase() == null || requestBody.getOutputCase().isEmpty())
            errorMap = getErrorMapByError(errorMap, OUTPUT_CASE_IS_EMPTY);
        // 에러가 없으면 null 반환, 있으면 에러 메시지 반환
        if (errorMap.isEmpty())
            return null;
        return CommonUtils.createErrorMessageDtoByErrorMap(errorMap);
    }

}
