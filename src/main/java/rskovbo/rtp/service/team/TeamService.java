package rskovbo.rtp.service.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import rskovbo.rtp.model.team.Team;
import rskovbo.rtp.model.user.User;
import rskovbo.rtp.repository.TeamRepository;

public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team registerTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team getTeam(User user) {
        return teamRepository.getOne(user.getTeamID());
    }
}
