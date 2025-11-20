package kz.kbtu.sis9.jwt.repository;

import kz.kbtu.sis9.jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
