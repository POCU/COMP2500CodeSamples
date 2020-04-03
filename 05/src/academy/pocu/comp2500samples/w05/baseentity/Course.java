package academy.pocu.comp2500samples.w05.baseentity;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.UUID;

public class Course extends BaseEntity {
    private String courseCode;
    private String title;
    private ArrayList<CourseTerm> courseTerms;

    public Course(UUID id,
                  OffsetDateTime createdDateTime,
                  OffsetDateTime modifiedDateTime,
                  String courseCode,
                  String title) {
        super(id, createdDateTime, modifiedDateTime);
        this.courseCode = courseCode;
        this.title = title;
        this.courseTerms = new ArrayList<>();
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<CourseTerm> getCourseTerms() {
        return this.courseTerms;
    }

    public void setCourseTerms(ArrayList<CourseTerm> courseTerms) {
        this.courseTerms = courseTerms;
    }

    // helper methods
    public void addCourseTerm(int term) {
        CourseTerm courseTerm = new CourseTerm(UUID.randomUUID(),
                OffsetDateTime.now(ZoneOffset.UTC),
                OffsetDateTime.now(ZoneOffset.UTC),
                this,
                term);

        this.courseTerms.add(courseTerm);
    }
}
