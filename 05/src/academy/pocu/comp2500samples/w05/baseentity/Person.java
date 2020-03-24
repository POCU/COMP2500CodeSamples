package academy.pocu.comp2500samples.w05.baseentity;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class Person extends BaseEntity {
    protected HashMap<String, Date> lastBuildDateTime;
    protected HashMap<String, Integer> buildsQueued;

    public Person(UUID id, Date createdDateTime, Date modifiedDateTime) {
        super(id, createdDateTime, modifiedDateTime);
    }

    public void completeBuild(int buildNumber) {
        this.buildsQueued.remove(key);
    }

    public void getBuildStatus(GradeItem gradeItem) {

    }
}
