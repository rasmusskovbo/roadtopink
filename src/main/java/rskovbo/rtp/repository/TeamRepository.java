package rskovbo.rtp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rskovbo.rtp.model.team.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}
