package academy.pocu.comp2500samples.w10.widgets;

public abstract class Widget {
    private static int numWidgets = 0;

    protected String label;
    protected int x;
    protected int y;

    public Widget(final int x,
                  final int y) {
        this(String.format("Widget%d", numWidgets), x, y);
    }

    public Widget(final String label,
                  final int x,
                  final int y) {
        this.label = label;
        this.x = x;
        this.y = y;
        numWidgets++;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(final String label) {
        this.label = label;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
