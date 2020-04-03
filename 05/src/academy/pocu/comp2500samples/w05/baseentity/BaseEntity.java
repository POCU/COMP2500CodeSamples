package academy.pocu.comp2500samples.w05.baseentity;

import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseEntity {
    private UUID id;
    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;

    public BaseEntity(UUID id, OffsetDateTime createdDateTime, OffsetDateTime modifiedDateTime) {
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

    public void setModifiedDateTime(OffsetDateTime modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }
}
