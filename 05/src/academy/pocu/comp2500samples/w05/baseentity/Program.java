package academy.pocu.comp2500samples.w05.baseentity;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        User user1 = new User(
                UUID.randomUUID(),
                OffsetDateTime.now(ZoneOffset.UTC),
                OffsetDateTime.now(ZoneOffset.UTC),
                "Tom",
                "Smith",
                "tommy hammer");

        printUserInformation(user1);

        BaseEntity user2 = new User(
                UUID.randomUUID(),
                OffsetDateTime.now(ZoneOffset.UTC),
                OffsetDateTime.now(ZoneOffset.UTC),
                "Kevin",
                "Park",
                "KtotheP");

        // Compile Error!
        // printUserInformation(user2);

        printUserInformation((User) user2);

        ((User) user2).setNickname("KevinInThePark");
        user2.setModifiedDateTime(OffsetDateTime.now(ZoneOffset.UTC));

        printUserInformation((User) user2);

        Course comp2500 = new Course(
                UUID.randomUUID(),
                OffsetDateTime.now(ZoneOffset.UTC),
                OffsetDateTime.now(ZoneOffset.UTC),
                "COMP2500",
                "Java");

        CourseTerm term202005 = new CourseTerm(
                UUID.randomUUID(),
                OffsetDateTime.now(ZoneOffset.UTC),
                OffsetDateTime.now(ZoneOffset.UTC),
                202005);

        term202005.setCourse(comp2500);
        comp2500.getCourseTerms().add(term202005);

        printCourseInformation(comp2500);

        comp2500.addCourseTerm(202009);

        printCourseInformation(comp2500);

        term202005.addStudent(user1);
        term202005.addStudent((User) user2);

        comp2500.setTitle("Object Oriented Programming and Design (Java)");

        printCourseInformation(comp2500);
    }

    private static void printUserInformation(User user) {
        System.out.println("user:");

        printBaseEntityInformation(user);

        System.out.println(String.format(
                "    name: %s",
                user.getName()));

        System.out.println(String.format(
                "    email: %s",
                user.getEmail()));

        System.out.println(String.format(
                "    nickname: %s",
                user.getNickname()));
    }

    private static void printCourseInformation(Course course) {
        System.out.println("course:");

        printBaseEntityInformation(course);

        System.out.println(String.format(
                "    course code: %s",
                course.getCourseCode()));

        System.out.println(String.format(
                "    title: %s",
                course.getTitle()));

        System.out.println("    course terms:");

        for (CourseTerm courseTerm : course.getCourseTerms()) {
            System.out.println(String.format(
                    "        term: %s",
                    courseTerm.getTerm()));
            System.out.println(String.format(
                    "        # students: %s",
                    courseTerm.getStudentCount()));
        }
    }

    private static void printBaseEntityInformation(BaseEntity entity) {
        System.out.println(String.format(
                "    id: %s",
                entity.getID()));

        System.out.println(String.format(
                "    created: %s",
                entity.getCreatedDateTime()));

        System.out.println(String.format(
                "    modified: %s",
                entity.getModifiedDateTime()));
    }
}
