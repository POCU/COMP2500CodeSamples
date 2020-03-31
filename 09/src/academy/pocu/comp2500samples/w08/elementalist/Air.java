package academy.pocu.comp2500samples.w08.elementalist;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class Air extends Attunement {
    private final int ELITE_SKILL_COOLDOWN_TIME_SEC = 80;

    public Air(Elementalist elementalist) {
        super(elementalist);
    }

    public void onEntry() {
        System.out.println("As fast as lightning!");
    }

    public void attack() {
        System.out.println("Electric whip!");
    }

    public void useEliteSkill(OffsetDateTime dateTime) {
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);

        if (now.compareTo(dateTime.plus(Duration.ofSeconds(ELITE_SKILL_COOLDOWN_TIME_SEC))) > 0) {
            System.out.println("You will be zapped!");
            System.out.println("1 million volt lightning!");
        } else {
            System.out.println("I can't use this yet!");
        }
    }

    public void onDeath() {
        System.out.println("I am wind...");
    }
}
