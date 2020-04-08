package academy.pocu.comp2500samples.w09.objectequality;

public final class Point {
    private int x;
    private int y;

    public Point(final int x, final int y) {
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
        if (obj == this) {
            return true;
        }

        if (obj == null
                || !(obj instanceof Point)) {
            return false;
        }

        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }
}
