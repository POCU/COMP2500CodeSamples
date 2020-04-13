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

        System.out.printf("id: %s\n",
                student1.getID());
        System.out.printf("createdDateTime: %s\n",
                student1.getCreatedDateTime());
        System.out.printf("modifiedDateTime: %s\n",
                student1.getModifiedDateTime());

        System.out.printf("name: %s\n",
                ((Student) student1).getName());
        System.out.printf("email: %s\n",
                ((Student) student1).getEmail());
        System.out.printf("nickname: %s\n",
                ((Student) student1).getNickname());

        System.out.println("---------------");

        id = UUID.randomUUID();

        final Student student2 = new Student(id,
                now,
                now,
                "Tony Stark",
                "tony.stark@pocu.academy",
                "Iron Man");

        System.out.printf("id: %s\n",
                student2.getID());
        System.out.printf("createdDateTime: %s\n",
                student2.getCreatedDateTime());
        System.out.printf("modifiedDateTime: %s\n",
                student2.getModifiedDateTime());

        System.out.printf("name: %s\n",
                student2.getName());
        System.out.printf("email: %s\n",
                student2.getEmail());
        System.out.printf("nickname: %s\n",
                student2.getNickname());
    }
}
