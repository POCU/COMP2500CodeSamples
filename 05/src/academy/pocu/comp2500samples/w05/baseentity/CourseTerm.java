package academy.pocu.comp2500samples.w05.baseentity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class CourseTerm extends BaseEntity {
    private int term;
    private Course course;
    private ArrayList<Student> students;

    public CourseTerm(UUID id, OffsetDateTime createdDateTime, OffsetDateTime modifiedDateTime, Course course, int term) {
        super(id, createdDateTime, modifiedDateTime);
        this.course = course;
        this.term = term;
        this.students = new ArrayList<>();
    }

    public int getTerm() {
        return this.term;
    }

    public Course getCourse() {
        return this.course;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    // helper methods
    public void addStudent(Student student) {
        this.students.add(student);
    }

    public int getStudentCount() {
        return this.students.size();
    }
}
