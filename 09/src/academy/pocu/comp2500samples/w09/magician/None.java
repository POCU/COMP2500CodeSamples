package academy.pocu.comp2500samples.w09.magician;

import java.time.OffsetDateTime;

public final class None extends Attunement {
    public None(Magician magician) {
        super(magician);
    }

    public void onEntry() {
        System.out.println("No attunement? Seriously? How am I even supposed to fight?");
    }

    public void attack() {
        System.out.println("Punch!");
    }

    public void useEliteSkill(final OffsetDateTime dateTime) {
        System.out.println("What elite attack? You expect me to punch monsters to death?");
    }

    public void onDeath() {
        System.out.println("I'll be back...");
    }
}
