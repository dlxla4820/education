package study.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.education.entity.Problem;

import java.util.UUID;
@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {
}
