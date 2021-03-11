package rskovbo.rtp.service.team;

import org.springframework.beans.factory.annotation.Autowired;
import rskovbo.rtp.repository.TeamRepository;

public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

}
