package academy.pocu.comp2500samples.w05.baseentity;

import java.util.Date;
import java.util.UUID;

public class TeachingAssistant extends Person {
    public TeachingAssistant(UUID id, Date createdDateTime, Date modifiedDateTime) {
        super(id, createdDateTime, modifiedDateTime);
    }

    public int buildWithoutCooldown(GradeItem gradeItem) {
        return 0;
    }
}
