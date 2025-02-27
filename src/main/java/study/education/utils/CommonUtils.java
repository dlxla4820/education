package study.education.utils;

import study.education.dto.ErrorMessageDto;
import study.education.enums.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static study.education.enums.Error.*;
public class CommonUtils {


    public static HashMap<String, List<String>> getErrorMapByError(Map<String, List<String>> errorMap, Error error) {
        // 기존 errorMap을 복사
        HashMap<String, List<String>> newErrorMap = new HashMap<>(errorMap);
        // 새로운 맵에 error 추가
        newErrorMap.computeIfAbsent(error.getKey(), k -> new ArrayList<>()).add(error.getMessage());
        return newErrorMap;
    }

    public static ErrorMessageDto<?> createErrorMessageDtoByErrorMap(HashMap<String, List<String>> errorMap){
        int totalErrorCount = errorMap.values().stream()
                .mapToInt(List::size)
                .sum();
        if(totalErrorCount == 1)
            return ErrorMessageDto.builder()
                    .message(errorMap.values().stream()
                            .flatMap(List::stream)
                            .collect(Collectors.joining(", ")))
                    .error(errorMap)
                    .build();
        else
            return ErrorMessageDto.builder()
                    .message(String.format("%s (and %d more error)",
                            errorMap.values().stream()
                                    .findFirst()
                                    .map(List::getFirst)
                                    .orElse("No errors found"),
                            totalErrorCount - 1))
                    .error(errorMap)
                    .build();
    }

}
