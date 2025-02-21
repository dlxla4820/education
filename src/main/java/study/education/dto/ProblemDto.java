package study.education.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import study.education.entity.Problem;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
@ToString
public class ProblemDto {
    private String title;
    private Integer level;
    private String content;
    private String restrictions;
    private String example;
    private Float timeCondition;
    private Integer memoryCondition;
    private String inputCase;
    private String outputCase;


    public Problem toProblemEntity(UUID userUUid){
        return Problem.builder()
                .userUUid(userUUid)
                .title(this.title)
                .level(this.level)
                .content(this.content)
                .restrictions(this.restrictions)
                .example(this.example)
                .timeCondition(this.timeCondition)
                .memoryCondition(this.memoryCondition)
                .inputCase(this.inputCase)
                .outputCase(this.outputCase)
                .build();
    }

    public static ProblemDto fromProblemEntity(Problem problem){
        return ProblemDto.builder()
                .title(problem.getTitle())
                .level(problem.getLevel())
                .content(problem.getContent())
                .restrictions(problem.getRestrictions())
                .example(problem.getExample())
                .timeCondition(problem.getTimeCondition())
                .memoryCondition(problem.getMemoryCondition())
                .inputCase(problem.getInputCase())
                .outputCase(problem.getOutputCase())
                .build();
    }
}
