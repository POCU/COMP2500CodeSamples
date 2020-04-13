package academy.pocu.comp2500samples.w10.abstractentitybase;

import java.time.OffsetDateTime;
import java.util.UUID;

public abstract class BaseEntity {
    private final UUID id;
    private final OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;

    public BaseEntity(final UUID id,
                      final OffsetDateTime createdDateTime,
                      final OffsetDateTime modifiedDateTime) {
        this.id = id;
        this.createdDateTime = createdDateTime;
        this.modifiedDateTime = modifiedDateTime;
    }

    public UUID getID() {
        return this.id;
    }

    public OffsetDateTime getCreatedDateTime() {
        return this.createdDateTime;
    }

    public OffsetDateTime getModifiedDateTime() {
        return this.modifiedDateTime;
    }

    public void setModifiedDateTime(final OffsetDateTime modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }
}
