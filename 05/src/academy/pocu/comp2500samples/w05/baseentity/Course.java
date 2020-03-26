package academy.pocu.comp2500samples.w05.baseentity;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.UUID;

public class Course extends BaseEntity {
    private String courseCode;
    private String title;
    private ArrayList<CourseTerm> courseTerms;

    public Course(
            final UUID id,
            final OffsetDateTime createdDateTime,
            final OffsetDateTime modifiedDateTime,
            final String courseCode,
            final String title) {
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

    public void setTitle(final String title) {
        this.title = title;
    }

    public ArrayList<CourseTerm> getCourseTerms() {
        return this.courseTerms;
    }

    public void setCourseTerms(final ArrayList<CourseTerm> courseTerms) {
        this.courseTerms = courseTerms;
    }

    // helper methods
    public void addCourseTerm(final int term) {
        CourseTerm courseTerm = new CourseTerm(
                UUID.randomUUID(),
                OffsetDateTime.now(ZoneOffset.UTC),
                OffsetDateTime.now(ZoneOffset.UTC),
                term);
        courseTerm.setCourse(this);

        this.courseTerms.add(courseTerm);
    }
}
