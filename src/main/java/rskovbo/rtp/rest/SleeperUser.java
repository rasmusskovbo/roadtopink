package rskovbo.rtp.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import rskovbo.rtp.model.user.User;

import javax.persistence.*;


@Table
@Entity(name = "sleeperuser")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SleeperUser {

    private final String avatarAPI = "https://sleepercdn.com/avatars/thumbs/";

    // Not a column, just foreign key connection
    @OneToOne(mappedBy = "sleeperUser")
    private User user;

    // SLEEPER DATA
    @Id
    @JsonProperty("user_id")
    @Column(name = "user_id")
    private Long userId;

    @JsonProperty("display_name")
    @Column
    private String displayName;

    @JsonProperty("avatar")
    @Column
    private String avatarId;

    private String avatarURL;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void updateAvatarURL() {
        this.avatarURL = "" + avatarAPI + avatarId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(String avatarId) {
        this.avatarId = avatarId;
    }

    @Override
    public String toString() {
        return "SleeperUser{" +
                "user=" + user +
                ", userId=" + userId +
                ", displayName='" + displayName + '\'' +
                ", avatarId='" + avatarId + '\'' +
                '}';
    }
}
