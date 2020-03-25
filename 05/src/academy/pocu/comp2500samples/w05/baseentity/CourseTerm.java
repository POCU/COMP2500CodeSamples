package academy.pocu.comp2500samples.w05.baseentity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class CourseTerm extends BaseEntity {
    private short term;
    private Course course;
    private ArrayList<User> students;

    public CourseTerm(
            final UUID id,
            final OffsetDateTime createdDateTime,
            final OffsetDateTime modifiedDateTime,
            final short term) {
        super(id, createdDateTime, modifiedDateTime);
        this.term = term;
        this.students = new ArrayList<>();
    }

    public short getTerm() {
        return this.term;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(final Course course) {
        this.course = course;
    }

    public ArrayList<User> getStudents() {
        return this.students;
    }

    public void setStudents(final ArrayList<User> students) {
        this.students = students;
    }

    public void addStudent(final User user) {
        this.students.add(user);
    }

    public int getStudentCount() {
        return this.students.size();
    }
}
