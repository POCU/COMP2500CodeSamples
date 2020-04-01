package academy.pocu.comp2500samples.w09.objectequality;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Point)) {
            return false;
        }

        if (super.equals(obj)) {
            return true;
        }

        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }
}
