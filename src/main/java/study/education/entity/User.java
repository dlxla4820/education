package study.education.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users") // 테이블 이름 변경
public class User {
    @Id
    @Column(length = 50, nullable = false)
    private String uuid;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100, unique = true, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    @CreationTimestamp
    private LocalDateTime regDate;

    @UpdateTimestamp
    private LocalDateTime modDate;

    @Column(length = 20, nullable = false)
    private String role = "USER";

    @Column(nullable = false)
    private Boolean isVerified = false;
}
