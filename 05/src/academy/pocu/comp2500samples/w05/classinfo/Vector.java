package academy.pocu.comp2500samples.w05.classinfo;

public class Vector {
    private int x;
    private int y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Vector add(final Vector other) {
        int sumX = this.x + other.x;
        int sumY = this.y + other.y;

        return new Vector(sumX, sumY);
    }

    public Vector subtract(final Vector other) {
        int diffX = this.x - other.x;
        int diffY = this.y - other.y;

        return new Vector(diffX, diffY);
    }

    public int dot(final Vector other) {
        int dotProduct = this.x * other.x + this.y * other.y;
        return dotProduct;
    }
}
