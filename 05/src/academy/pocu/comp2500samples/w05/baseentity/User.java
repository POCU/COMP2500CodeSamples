package academy.pocu.comp2500samples.w05.baseentity;

import java.time.OffsetDateTime;
import java.util.UUID;

public class User extends BaseEntity {
    private String name;
    private String email;
    private String nickname;

    public User(
            final UUID id,
            final OffsetDateTime createdDateTime,
            final OffsetDateTime modifiedDateTime,
            final String name,
            final String email,
            final String nickname) {
        super(id, createdDateTime, modifiedDateTime);
        this.name = name;
        this.email = email;
        this.nickname = nickname;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }
}
