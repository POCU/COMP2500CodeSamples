package academy.pocu.comp2500samples.w09.magician;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class Water extends Attunement {
    private final int ELITE_SKILL_COOLDOWN_TIME_SEC = 75;

    public Water(Magician magician) {
        super(magician);
    }

    public void onEntry() {
        System.out.println("Water! The giver of life!");
    }

    public void attack() {
        System.out.println("Water gun!");
    }

    public void useEliteSkill(OffsetDateTime dateTime) {
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);

        if (now.compareTo(dateTime.plus(Duration.ofSeconds(ELITE_SKILL_COOLDOWN_TIME_SEC))) > 0) {
            System.out.println("Alright, let's surf!");
            System.out.println("Poseidon's fury! Tsunami~~~!!");
        } else {
            System.out.println("I can't use this yet!");
        }
    }

    public void onDeath() {
        System.out.println("Help! I can't swim!");
    }
}
