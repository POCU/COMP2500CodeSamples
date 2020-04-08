package academy.pocu.comp2500samples.w09.magician;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public final class Magician {
    private String name;
    private Attunement attunement;
    private OffsetDateTime lastEliteAttackUsedDateTime;

    public Magician(String name) {
        this.name = name;
        this.attunement = new None(this);
        this.lastEliteAttackUsedDateTime = OffsetDateTime.of(1, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
    }

    public String getName() {
        return this.name;
    }

    public void setAttunement(final Attunement attunement) {
        if (this.attunement.getClass() != attunement.getClass()) {
            this.attunement = attunement;
            this.attunement.onEntry();
        }
    }

    public void attack() {
        this.attunement.attack();
    }

    public void useEliteSkill() {
        this.attunement.useEliteSkill(this.lastEliteAttackUsedDateTime);
        this.lastEliteAttackUsedDateTime = OffsetDateTime.now(ZoneOffset.UTC);
    }

    public void onDeath() {
        this.attunement.onDeath();
        this.lastEliteAttackUsedDateTime = OffsetDateTime.of(1, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
    }
}
