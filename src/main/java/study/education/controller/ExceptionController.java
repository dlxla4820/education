package study.education.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import study.education.exception.UnprocessableException;

@ControllerAdvice
@Slf4j
public class ExceptionController {


    @ExceptionHandler(UnprocessableException.class)
    public ResponseEntity<?> handleUnprocessableException(UnprocessableException ex) {
        log.error(getStackTraceMessage(ex));
        return new ResponseEntity<>(ex.getErrorMessageDto(), HttpStatus.UNPROCESSABLE_ENTITY);  // 422 UNPROCESSABLE_ENTITY
    }






    // 클래스, 메서드, 에러메시지 출력
    private String getStackTraceMessage(Throwable t) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        if (stackTrace.length > 1) {
            StackTraceElement callingMethod = stackTrace[1];
            String className = callingMethod.getClassName();
            String methodName = callingMethod.getMethodName();
            int lineNumber = callingMethod.getLineNumber();
            StackTraceElement exceptionMethod = stackTrace[0];
            return String.format("Exception occurred in method: %s (class: %s, line: %d) " +
                            "called from method: %s (class: %s, line: %d) - %s",
                    exceptionMethod.getMethodName(),
                    exceptionMethod.getClassName(),
                    exceptionMethod.getLineNumber(),
                    methodName,
                    className,
                    lineNumber,
                    t.getMessage());
        } else {
            return String.format("Exception occurred: %s", t.getMessage());
        }
    }
}
