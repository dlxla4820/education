package study.education.exception;

import lombok.Getter;
import study.education.dto.ErrorMessageDto;
import static study.education.utils.Constant.UNPROCESSABLE_EXCEPTION;

@Getter
public class UnprocessableException extends RuntimeException{
    private final ErrorMessageDto<?> errorMessageDto;

    public UnprocessableException(ErrorMessageDto<?> errorMessageDto) {
        super(UNPROCESSABLE_EXCEPTION);  // super()에 메시지를 전달
        this.errorMessageDto = errorMessageDto;  // ErrorMessageDto 저장
    }
}
