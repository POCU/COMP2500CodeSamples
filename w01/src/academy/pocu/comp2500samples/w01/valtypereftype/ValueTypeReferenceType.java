package academy.pocu.comp2500samples.w01.valtypereftype;

public class ValueTypeReferenceType {

    public static void main(String[] args) {
        int x = 5;
        Vector vec = new Vector(4, 6);

        modifyValueType(x);
        System.out.println(String.format("x: %d", x));

        modifyRefType(vec);
        System.out.println(String.format("vec.X: %d, vec.Y: %d", vec.X, vec.Y));

        reassignRefType(vec);
        System.out.println(String.format("vec.X: %d, vec.Y: %d", vec.X, vec.Y));

        modifyValueTypeWithFinal(x);
        System.out.println(String.format("x: %d", x));

        modifyRefTypeWithFinal(vec);
        System.out.println(String.format("vec.X: %d, vec.Y: %d", vec.X, vec.Y));
    }

    private static void modifyValueType(int x) {
        x += 5;
    }

    private static void modifyRefType(Vector vec) {
        vec.X += 15;
        vec.Y += 10;
    }

    private static void reassignRefType(Vector vec) {
        vec = new Vector(2, 3);
    }

    private static void modifyValueTypeWithFinal(final int x) {
        // Compile error if uncommented
        // x += 5;
    }

    private static void modifyRefTypeWithFinal(final Vector vec) {
        // Compile error if uncommented
        // vec = new Vector(2, 3);

        vec.X -= 15;
        vec.Y -= 10;
    }
}
