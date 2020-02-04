package academy.pocu.comp2500samples.w01.valtypereftype;

public class ValueTypeReferenceType {

    public static void main(String[] args) {
        int x = 5;
        Vector vec = new Vector(4, 6);

        modifyValueType(x);
        System.out.println(String.format("x: %d", x));

        modifyRefType(vec);
        System.out.println(String.format("vec.X: %d, vec.Y: %d", vec.x, vec.y));

        reassignRefType(vec);
        System.out.println(String.format("vec.X: %d, vec.Y: %d", vec.x, vec.y));

        modifyValueTypeWithFinal(x);
        System.out.println(String.format("x: %d", x));

        modifyRefTypeWithFinal(vec);
        System.out.println(String.format("vec.X: %d, vec.Y: %d", vec.x, vec.y));
    }

    private static void modifyValueType(int x) {
        x += 5;
    }

    private static void modifyRefType(Vector vec) {
        vec.x += 15;
        vec.y += 10;
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

        vec.x -= 15;
        vec.y -= 10;
    }
}
