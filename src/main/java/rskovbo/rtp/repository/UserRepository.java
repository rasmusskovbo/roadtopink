package rskovbo.rtp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rskovbo.rtp.model.user.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // SELECT * FROM user WHERE email = username
    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByUsernameAndPw(String username, String pw);


}
