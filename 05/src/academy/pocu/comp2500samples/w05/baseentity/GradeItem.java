package academy.pocu.comp2500samples.w05.baseentity;

import java.util.Date;
import java.util.UUID;

public class GradeItem extends BaseEntity {
    private GradeItemType gradeItemType;
    private int number;

    public GradeItem(UUID id, Date createdDateTime, Date modifiedDateTime, GradeItemType gradeItemType, int number) {
        super(id, createdDateTime, modifiedDateTime);
        this.gradeItemType = gradeItemType;
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public GradeItemType getGradeItemType() {
        return this.gradeItemType;
    }
}
