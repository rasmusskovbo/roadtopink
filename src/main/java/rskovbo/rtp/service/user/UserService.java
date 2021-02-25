package rskovbo.rtp.service.user;

import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import rskovbo.rtp.model.user.User;
import rskovbo.rtp.repository.UserRepository;

import javax.security.auth.login.LoginException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService  {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User registerUser(User user) throws UsernameAlreadyExists {
        Optional<User> userOptional = userRepository.findUserByUsername(user.getUsername());
        if (userOptional.isPresent()) {
            throw new UsernameAlreadyExists("Username already exists");
        }
        return userRepository.save(user);
    }

    public User login(String username, String password) throws LoginException {
        Optional<User> userOptional = userRepository.findUserByUsernameAndPw(username, password);
        if (userOptional.isEmpty()) {
            throw new LoginException("Username or password did not match");
        }
        Long id = userOptional.get().getId();
        System.out.println(id);
        return userRepository.getOne(id);
    }

    public User getUser(Long id) {
        return userRepository.getOne(id);
    }


}
