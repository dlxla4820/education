package study.education.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@Table(name = "problem")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "problem_seq")
    @SequenceGenerator(name = "problem_seq", sequenceName = "problem_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_uuid")
    private UUID userUUid;

    @Column(name = "title")
    private String title;

    @Column(name = "level")
    private Integer level;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "TEXT")
    private String restrictions;

    @Column(name = "example", columnDefinition = "TEXT")
    private String example;

    @Column(name = "time condition")
    private Float timeCondition;

    @Column(name = "memory condition")
    private Integer memoryCondition;

    @Column(name = "input_case")
    private String inputCase;

    @Column(name="output_case")
    private String outputCase;


}
