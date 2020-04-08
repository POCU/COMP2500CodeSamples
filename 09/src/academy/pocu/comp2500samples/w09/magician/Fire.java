package academy.pocu.comp2500samples.w09.magician;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public final class Fire extends Attunement {
    private final int ELITE_SKILL_COOLDOWN_SECS = 90;

    public Fire(final Magician magician) {
        super(magician);
    }

    public void onEntry() {
        System.out.println("I am fire! Burn everything to the ground!");
    }

    public void attack() {
        System.out.println("Fire~~~ Ball~~~~~!!!");
    }

    public void useEliteSkill(final OffsetDateTime lastEliteAttackUsedDateTime) {
        final OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);

        final Duration cooldown = Duration.ofSeconds(ELITE_SKILL_COOLDOWN_SECS);

        final OffsetDateTime cooldownExpireDateTime = lastEliteAttackUsedDateTime.plus(cooldown);

        if (now.compareTo(cooldownExpireDateTime) > 0) {
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
