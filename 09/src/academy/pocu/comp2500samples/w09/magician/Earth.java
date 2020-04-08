package academy.pocu.comp2500samples.w09.magician;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public final class Earth extends Attunement {
    private final int ELITE_SKILL_COOLDOWN_SECS = 100;

    public Earth(Magician magician) {
        super(magician);
    }

    public void onEntry() {
        System.out.println("As heavy as earth!");
    }

    public void attack() {
        System.out.println("Stone edge!");
    }

    public void useEliteSkill(final OffsetDateTime lastEliteAttackUsedDateTime) {
        final OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);

        final Duration cooldown = Duration.ofSeconds(ELITE_SKILL_COOLDOWN_SECS);
        final OffsetDateTime cooldownExpireDateTime = lastEliteAttackUsedDateTime.plus(cooldown);

        if (now.compareTo(cooldownExpireDateTime) > 0) {
            System.out.println("Feel the wrath of Mother Earth!");
            System.out.println("Earthquake!");
        } else {
            System.out.println("I can't use this yet!");
        }
    }

    public void onDeath() {
        System.out.println("Now I rest in Mother Earth...");
    }
}
