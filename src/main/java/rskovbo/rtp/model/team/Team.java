package rskovbo.rtp.model.team;

import rskovbo.rtp.model.user.User;

import javax.persistence.*;

@Table
@Entity(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, name = "id")
    private Long id;

    @Column(nullable = false)
    private String teamName;

    @OneToOne(mappedBy = "team")
    private User user;

    //@Column TODO
    // private List<> stats

    public Team() {
    }

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
