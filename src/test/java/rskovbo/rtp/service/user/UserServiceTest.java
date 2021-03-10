package rskovbo.rtp.service.user;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import rskovbo.rtp.model.user.User;
import rskovbo.rtp.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@SpringBootTest
class UserServiceTest {

    @InjectMocks
    DataService dataService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        User user = new User("Test", "1234", "Testi", "Testisen");
        Mockito.when(userRepository.getOne(1L)).thenReturn(user);
    }

    @Test
    void getUsers() {
    }

    @Test
    void save() {
    }

    @Test
    void registerUser() {
    }

    @Test
    void login() {
    }

    @Test
    void getUser() {
        Long id = 1L;
        //Arrange
        assertEquals("Testi", userRepository.getOne(id).getFirstName());
        Mockito.verify(userRepository, times(1)).getOne(id);
    }
}