package academy.pocu.comp2500samples.w05.baseentity;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        UUID id = UUID.randomUUID();
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);

        Student student1 = new Student(id,
                now,
                now,
                "Tom",
                "Smith",
                "tommy hammer");

        printStudentInformation(student1);

        id = UUID.randomUUID();
        now = OffsetDateTime.now(ZoneOffset.UTC);

        BaseEntity student2 = new Student(id,
                now,
                now,
                "Kevin",
                "Park",
                "KtotheP");

        // Compile Error!
        // printStudentInformation(student2);

        printStudentInformation((Student) student2);

        ((Student) student2).setNickname("KevinInThePark");

        now = OffsetDateTime.now(ZoneOffset.UTC);
        student2.setModifiedDateTime(now);

        printStudentInformation((Student) student2);

        id = UUID.randomUUID();
        now = OffsetDateTime.now(ZoneOffset.UTC);

        Course comp2500 = new Course(id,
                now,
                now,
                "COMP2500",
                "Java");

        id = UUID.randomUUID();
        now = OffsetDateTime.now(ZoneOffset.UTC);

        CourseTerm term202005 = new CourseTerm(id,
                now,
                now,
                comp2500,
                202005);

        comp2500.getCourseTerms().add(term202005);

        printCourseInformation(comp2500);

        comp2500.addCourseTerm(202009);

        printCourseInformation(comp2500);

        term202005.addStudent(student1);
        term202005.addStudent((Student) student2);

        comp2500.setTitle("Object Oriented Programming and Design (Java)");

        printCourseInformation(comp2500);
    }

    private static void printStudentInformation(Student student) {
        System.out.println("student:");

        printBaseEntityInformation(student);

        System.out.printf ("    name: %s\n",
                student.getName());

        System.out.printf("    email: %s\n",
                student.getEmail());

        System.out.printf("    nickname: %s\n",
                student.getNickname());
    }

    private static void printCourseInformation(Course course) {
        System.out.println("course:");

        printBaseEntityInformation(course);

        System.out.printf("    course code: %s\n",
                course.getCourseCode());

        System.out.printf("    title: %s\n",
                course.getTitle());

        System.out.println("    course terms:");

        for (CourseTerm courseTerm : course.getCourseTerms()) {
            System.out.printf("        term: %s\n",
                    courseTerm.getTerm());
            System.out.printf("        # students: %s\n",
                    courseTerm.getStudentCount());
        }
    }

    private static void printBaseEntityInformation(BaseEntity entity) {
        System.out.printf("    id: %s\n",
                entity.getID());

        System.out.printf("    created: %s\n",
                entity.getCreatedDateTime());

        System.out.printf("    modified: %s\n",
                entity.getModifiedDateTime());
    }
}
