package academy.pocu.comp2500samples.w05.baseentity;

import java.util.Date;
import java.util.UUID;

public class BaseEntity {
    private final UUID id;
    private final Date createdDateTime;
    private Date modifiedDateTime;

    public BaseEntity(UUID id, Date createdDateTime, Date modifiedDateTime) {
        this.id = id;
        this.createdDateTime = createdDateTime;
        this.modifiedDateTime = modifiedDateTime;
    }

    public UUID getID() {
        return this.id;
    }

    public Date getCreatedDateTime() {
        return this.createdDateTime;
    }

    public Date getModifiedDateTime() {
        return this.modifiedDateTime;
    }

    public void setModifiedDateTime(Date modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }
}
