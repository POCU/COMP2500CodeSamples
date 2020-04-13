package academy.pocu.comp2500samples.w10.widgets;

public final class Button extends Widget implements IClickable {
    public Button(int x, int y) {
        super(x, y);
    }

    public Button(String label, int x, int y) {
        super(label, x, y);
    }

    @Override
    public void onClick() {
        System.out.printf("Button %s clicked!%s",
                this.label,
                System.lineSeparator());
    }
}
