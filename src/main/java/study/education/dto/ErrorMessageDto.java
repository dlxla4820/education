package study.education.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ErrorMessageDto<E> {
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private E error;
}
