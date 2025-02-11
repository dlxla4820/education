package study.education.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import study.education.entity.Quiz;

import java.util.Map;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuizRequestDto {
    private String title;
    private String content;
    private String restrictions;
    private Map<String, Object> example;
    private String exampleExplanation;
    private String code;
    private Float timeCondition;
    private Map<String, Object> answer;


    public Quiz toQuizEntity(){
        return Quiz.builder()
                .title(this.title)
                .content(this.content)
                .restrictions(this.restrictions)
                .example(this.example)
                .exampleExplanation(this.exampleExplanation)
                .code(this.code)
                .timeCondition(this.timeCondition)
                .answer(this.answer)
                .build();
    }
}
