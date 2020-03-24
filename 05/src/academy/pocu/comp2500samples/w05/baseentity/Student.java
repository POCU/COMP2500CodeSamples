package academy.pocu.comp2500samples.w05.baseentity;

import java.util.Date;
import java.util.UUID;

public class Student extends Person {
    public Student(UUID id, Date createdDateTime, Date modifiedDateTime) {
        super(id, createdDateTime, modifiedDateTime);
    }

    public int build(GradeItem gradeItem) {
        return 0;
    }
}
