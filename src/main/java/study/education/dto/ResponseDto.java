package study.education.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.StringJoiner;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto<T> {
    private Integer code;
    private T data;

    @Override
    public String toString() {
        return new StringJoiner(", ", ResponseDto.class.getSimpleName() + "[", "]")
                .add("code='" + code + "'")
                .add("data='" + data + "'")
                .toString();
    }
}