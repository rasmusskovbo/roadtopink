package rskovbo.rtp.rest;

import java.util.List;

public interface ApiService {

    List<SleeperUser> getUsers(Integer limit);
}
