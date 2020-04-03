package academy.pocu.comp2500samples.w09.magician;

public class Program {
    public static void main(String[] args) {
        Magician magician = new Magician("Wizard of Oz");

        magician.attack();
        magician.useEliteSkill();
        magician.onDeath();

        magician.setAttunement(new Fire(magician));

        magician.attack();
        magician.useEliteSkill();
        magician.onDeath();

        magician.setAttunement(new Fire(magician));
        magician.setAttunement(new Water(magician));

        magician.attack();
        magician.useEliteSkill();
        magician.onDeath();

        magician.setAttunement(new Air(magician));

        magician.attack();
        magician.useEliteSkill();
        magician.onDeath();

        magician.setAttunement(new Earth(magician));

        magician.attack();
        magician.useEliteSkill();
        magician.onDeath();

        magician.setAttunement(new None(magician));
    }
}
