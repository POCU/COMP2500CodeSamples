package academy.pocu.comp2500samples.w08.elementalist;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class Elementalist {
    private String name;
    private int hp;
    private Attunement attunement;
    private OffsetDateTime lastEliteAttackUsageDateTime;

    public Elementalist(String name, int hp) {
        assert (hp > 0) : "hp must be greater than 0";

        this.name = name;
        this.hp = hp;
        this.attunement = new None(this);
        this.lastEliteAttackUsageDateTime = OffsetDateTime.of(0,
                0,
                0,
                0,
                0,
                0,
                0,
                ZoneOffset.UTC);
    }

    public String getName() {
        return this.name;
    }

    public int getHp() {
        return this.hp;
    }

    public void setAttunement(Attunement attunement) {
        if (this.attunement.getClass() != attunement.getClass()) {
            this.attunement = attunement;
            this.attunement.onEntry();
        }
    }

    public void attack() {
        this.attunement.attack();
    }

    public void useEliteSkill() {
        this.attunement.useEliteSkill(this.lastEliteAttackUsageDateTime);
    }

    public void onDeath() {
        this.attunement.onDeath();
        this.lastEliteAttackUsageDateTime = OffsetDateTime.of(0,
                0,
                0,
                0,
                0,
                0,
                0,
                ZoneOffset.UTC);
    }
}
