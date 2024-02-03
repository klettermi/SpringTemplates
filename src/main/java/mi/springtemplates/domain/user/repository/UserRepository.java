package mi.springtemplates.domain.user.repository;

import mi.springtemplates.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);

    Optional<User> findByNickname(String nickname);

    Optional<User> findByEmail(String email);
}