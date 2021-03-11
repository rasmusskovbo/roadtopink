package rskovbo.rtp.model.user;

import rskovbo.rtp.model.team.Team;
import rskovbo.rtp.rest.SleeperUser;

import javax.persistence.*;

@Table(uniqueConstraints = {@UniqueConstraint(name = "user_username_unique", columnNames = "username")})
@Entity(name = "user")
public class User {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sleeper_user_id", referencedColumnName = "user_id")
    private SleeperUser sleeperUser;

    public User() {
    }

    public User(String username, String pw, String firstName, String lastName) {
        this.username = username;
        this.pw = pw;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //--Getters & Setters
    public SleeperUser getSleeperUser() {
        return sleeperUser;
    }

    public void setSleeperUser(SleeperUser sleeperUser) {
        sleeperUser.updateAvatarURL();
        this.sleeperUser = sleeperUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String password) {
        this.pw = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

/*
    public Long getTeamID() {
        return teamID;
    }

    public void setTeamID(Long teamID) {
        this.teamID = teamID;
    }
 */

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pw='" + pw + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
