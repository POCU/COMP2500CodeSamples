package academy.pocu.comp2500samples.w01.valtypereftype;

public class ValueTypeReferenceType {

    public static void main(String[] args) {
        Vector vec = new Vector(4, 6);

        modifyVector(vec);
        System.out.println(String.format("vec.X: %d, vec.Y: %d", vec.X, vec.Y));

        int x = 5;
        reassignXAndVector(x, vec);
        System.out.println(String.format("x: %d, vec.X: %d, vec.Y: %d", x, vec.X, vec.Y));

        modifyXAndVectorWithFinalKeyword(x, vec);
        System.out.println(String.format("x: %d, vec.X: %d, vec.Y: %d", x, vec.X, vec.Y));
    }

    public static void modifyVector(Vector vec) {
        vec.X += 15;
        vec.Y += 10;
    }

    public static void reassignXAndVector(int x, Vector vec) {
        x += 6;
        vec = new Vector(2, 3);
    }

    public static void modifyXAndVectorWithFinalKeyword(final int x, final Vector vec) {
        // Compile error if uncommented
        // x += 6;
        // vec = new Vector(2, 3);

        vec.X -= 15;
        vec.Y -= 15;
    }
}
