package academy.pocu.comp2500samples.w10.abstractentitybase;

import java.time.OffsetDateTime;
import java.util.UUID;

public final class Student extends BaseEntity {
    private String name;
    private String email;
    private String nickname;

    public Student(final UUID id,
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

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }
}
