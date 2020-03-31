package academy.pocu.comp2500samples.w08.elementalist;

public class Program {
    public static void main(String[] args) {
        Elementalist elementalist = new Elementalist("Wizard of Oz");

        elementalist.attack();
        elementalist.useEliteSkill();
        elementalist.onDeath();

        elementalist.setAttunement(new Fire(elementalist));

        elementalist.attack();
        elementalist.useEliteSkill();
        elementalist.onDeath();

        elementalist.setAttunement(new Fire(elementalist));
        elementalist.setAttunement(new Water(elementalist));

        elementalist.attack();
        elementalist.useEliteSkill();
        elementalist.onDeath();

        elementalist.setAttunement(new Air(elementalist));

        elementalist.attack();
        elementalist.useEliteSkill();
        elementalist.onDeath();

        elementalist.setAttunement(new Earth(elementalist));

        elementalist.attack();
        elementalist.useEliteSkill();
        elementalist.onDeath();

        elementalist.setAttunement(new None(elementalist));
    }
}
