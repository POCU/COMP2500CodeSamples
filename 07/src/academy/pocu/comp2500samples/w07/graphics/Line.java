package academy.pocu.comp2500samples.w07.graphics;

public class Line extends Graphic {
    private Point p1;
    private Point p2;

    public Line(String label,
                Point p1,
                Point p2) {
        super(label);
        this.p1 = p1;
        this.p2 = p2;
    }

    public double getLength() {
        int xDiff = this.p1.getX() - this.p2.getX();
        int yDiff = this.p1.getY() - this.p2.getY();

        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    public void draw() {
        System.out.printf("Draw line '%s'\n", this.label);
    }
}
