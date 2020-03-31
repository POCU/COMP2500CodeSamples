package academy.pocu.comp2500samples.w09.hashcode;

public class VectorWithHashcode {
    private short x;
    private short y;

    public VectorWithHashcode(short x, short y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object obj) {
        if (obj == null
                || this.hashCode() != obj.hashCode()
                || !(obj instanceof VectorWithHashcode)) {
            return false;
        }

        VectorWithHashcode other = (VectorWithHashcode)obj;
        return this.x == other.x && this.y == other.y;
    }

    public int hashCode() {
        return (this.x << 16) | this.y;
    }
}
