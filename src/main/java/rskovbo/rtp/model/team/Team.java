package rskovbo.rtp.model.team;

import javax.persistence.*;

@Table
@Entity(name = "Team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    //@Column TODO
    // private List<> stats
}
