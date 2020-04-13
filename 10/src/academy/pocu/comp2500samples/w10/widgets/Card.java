package academy.pocu.comp2500samples.w10.widgets;

public final class Card extends Widget implements IDraggable {
    private String content;

    public Card(int x, int y) {
        super(x, y);
    }

    public Card(String label, int x, int y) {
        super(label, x, y);
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    @Override
    public void onDrag(int x, int y) {
        System.out.printf("Drag Card %s from [ %d, %d ] -> [ %d, %d ]!%s",
                this.label,
                this.x,
                this.y,
                x,
                y,
                System.lineSeparator());

        this.x = x;
        this.y = y;
    }
}
