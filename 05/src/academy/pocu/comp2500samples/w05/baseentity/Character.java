package academy.pocu.comp2500samples.w05.baseentity;

import java.util.UUID;

public class Character extends BaseEntity {
    protected String name;

    public Character(UUID id) {
        super(id);
    }

    public void sayName() {
        System.out.println("");
    }

    public void runAway() {

    }
}
