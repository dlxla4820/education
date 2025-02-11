package study.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.education.entity.Quiz;

import java.util.UUID;
@Repository
public interface QuizRepository extends JpaRepository<Quiz, UUID> {
}
