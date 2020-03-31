package academy.pocu.comp2500samples.w08.elementalist;

import java.time.OffsetDateTime;

public class None extends Attunement {
    public None(Elementalist elementalist) {
        super(elementalist);
    }

    public void onEntry() {
        System.out.println("No attunement? Seriously? How am I even supposed to fight?");
    }

    public void attack() {
        System.out.println("Punch!");
    }

    public void useEliteSkill(OffsetDateTime dateTime) {
        System.out.println("What elite attack? You expect me to punch monsters to death?");
    }

    public void onDeath() {
        System.out.println("I'll be back...");
    }
}
