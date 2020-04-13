package academy.pocu.comp2500samples.w10.abstractentitybase;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        UUID id = UUID.randomUUID();
        final OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);

        // Compile error
        // final BaseEntity entity = new BaseEntity(id, now, now);

        final BaseEntity student1 = new Student(id,
                now,
                now,
                "Peter Parker",
                "peter.parker@pocu.academy",
                "Spider Man");

        System.out.printf("id: %s%s",
                student1.getID(),
                System.lineSeparator());
        System.out.printf("createdDateTime: %s%s",
                student1.getCreatedDateTime(),
                System.lineSeparator());
        System.out.printf("modifiedDateTime: %s%s",
                student1.getModifiedDateTime(),
                System.lineSeparator());

        System.out.printf("name: %s%s",
                ((Student) student1).getName(),
                System.lineSeparator());
        System.out.printf("email: %s%s",
                ((Student) student1).getEmail(),
                System.lineSeparator());
        System.out.printf("nickname: %s%s",
                ((Student) student1).getNickname(),
                System.lineSeparator());

        System.out.println("---------------");

        id = UUID.randomUUID();

        final Student student2 = new Student(id,
                now,
                now,
                "Tony Stark",
                "tony.stark@pocu.academy",
                "Iron Man");

        System.out.printf("id: %s%s",
                student2.getID(),
                System.lineSeparator());
        System.out.printf("createdDateTime: %s%s",
                student2.getCreatedDateTime(),
                System.lineSeparator());
        System.out.printf("modifiedDateTime: %s%s",
                student2.getModifiedDateTime(),
                System.lineSeparator());

        System.out.printf("name: %s%s",
                student2.getName(),
                System.lineSeparator());
        System.out.printf("email: %s%s",
                student2.getEmail(),
                System.lineSeparator());
        System.out.printf("nickname: %s%s",
                student2.getNickname(),
                System.lineSeparator());
    }
}
