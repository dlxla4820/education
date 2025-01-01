package study.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.education.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
