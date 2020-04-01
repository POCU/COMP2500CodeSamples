package academy.pocu.comp2500samples.w09.objectequals;

public class Line {
    private Point p1;
    private Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double getLength() {
        int xDiff = this.p1.getX() - this.p2.getX();
        int yDiff = this.p1.getY() - this.p2.getY();

        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Line)) {
            return false;
        }

        if (super.equals(obj)) {
            return true;
        }

        Line other = (Line) obj;
        return this.p1.equals(other.p1) && this.p2.equals(other.p2);
    }
}