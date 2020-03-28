package academy.pocu.comp2500samples.w07.graphics;

public class Point extends Graphic {
    private int x;
    private int y;

    public Point(String label, int x, int y) {
        super(label);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void draw() {
        System.out.println(String.format(
                "Draw point '%s'",
                this.label));
    }
}
