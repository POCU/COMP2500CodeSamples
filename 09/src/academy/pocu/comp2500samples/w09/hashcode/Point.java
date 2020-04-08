package academy.pocu.comp2500samples.w09.hashcode;

public final class Point {
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
        if (obj == this) {
            return true;
        }

        if (obj == null
                || !(obj instanceof Point)
                || this.hashCode() != obj.hashCode()) {
            return false;
        }

        Point other = (Point)obj;
        return this.x == other.x && this.y == other.y;
    }

    public int hashCode() {
        return this.x * 31 + this.y;
    }
}
