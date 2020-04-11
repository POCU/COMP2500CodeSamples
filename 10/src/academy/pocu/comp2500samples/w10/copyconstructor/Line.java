package academy.pocu.comp2500samples.w10.copyconstructor;

public class Line {
    private Point p1;
    private Point p2;

    public Line(final Point p1,
                final Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Line(final Line other) {
        this.p1 = new Point(other.p1);
        this.p2 = new Point(other.p2);
    }

    public double getLength() {
        int xDiff = this.p1.getX() - this.p2.getX();
        int yDiff = this.p1.getY() - this.p2.getY();

        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    public Point getP1() {
        return this.p1;
    }

    public Point getP2() {
        return this.p2;
    }
}
