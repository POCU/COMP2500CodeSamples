package academy.pocu.comp2500samples.w09.hashcode;

public class VectorWithoutHashcode {
    private short x;
    private short y;

    public VectorWithoutHashcode(short x, short y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof VectorWithoutHashcode)) {
            return false;
        }

        VectorWithoutHashcode other = (VectorWithoutHashcode)obj;
        return this.x == other.x && this.y == other.y;
    }
}
