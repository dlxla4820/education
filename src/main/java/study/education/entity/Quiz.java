package study.education.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@Table(name = "quiz")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Quiz {

    @Id
    @Column(nullable = false)
    @Builder.Default
    private UUID uuid = UUID.randomUUID();

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "TEXT")
    private String restrictions;

    @ColumnDefault("'{}'::json")
    @Column(name = "example")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> example;

    @Column(name = "example_explanation", columnDefinition = "TEXT")
    private String exampleExplanation;

    @Column(name = "code", columnDefinition = "TEXT")
    private String code;

    @Column(name = "time condition")
    private Float timeCondition;

    @ColumnDefault("'{}'::json")
    @Column(name = "example")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> answer;
}
