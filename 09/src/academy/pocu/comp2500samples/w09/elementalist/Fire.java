package academy.pocu.comp2500samples.w09.elementalist;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class Fire extends Attunement {
    private final int ELITE_SKILL_COOLDOWN_TIME_SEC = 90;

    public Fire(Elementalist elementalist) {
        super(elementalist);
    }

    public void onEntry() {
        System.out.println("I am fire! Burn everything to the ground!");
    }

    public void attack() {
        System.out.println("Fire~~~ Ball~~~~~!!!");
    }

    public void useEliteSkill(OffsetDateTime dateTime) {
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);

        if (now.compareTo(dateTime.plus(Duration.ofSeconds(ELITE_SKILL_COOLDOWN_TIME_SEC))) > 0) {
            System.out.println("Burn everything to cinders!");
            System.out.println("Fire~~~~ Storm~~~~!!!!");
        } else {
            System.out.println("I can't use this yet!");
        }
    }

    public void onDeath() {
        System.out.println("I will rise again like a phoenix...");
    }
}
