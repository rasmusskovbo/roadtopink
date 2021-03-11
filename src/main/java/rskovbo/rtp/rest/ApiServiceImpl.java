package rskovbo.rtp.rest;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    final String BASE_URL = "https://api.sleeper.app/v1/league/651758124012740608/users";

    private RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<SleeperUser> getUsers(Integer limit) {
        ResponseEntity<List<SleeperUser>> responseEntity =
                restTemplate.exchange(
                        BASE_URL,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<SleeperUser>>() {}
                );
        List<SleeperUser> users = responseEntity.getBody();
        return users;
    }
}
