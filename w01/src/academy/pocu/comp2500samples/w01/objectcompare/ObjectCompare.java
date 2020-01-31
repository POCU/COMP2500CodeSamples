package academy.pocu.comp2500samples.w01.objectcompare;

public class ObjectCompare {

    public static void main(String[] args) {
        String str1 = "Luffy";
        String str2 = "Nami";
        String str3 = new String("Luffy");
        String str4 = str3;

        // Compile error if uncommented
        // str2[0] = 'M';

        System.out.println(String.format("str1 == str2: %b", str1 == str2));
        System.out.println(String.format("str1 == str3: %b", str1 == str3));
        System.out.println(String.format("str3 == str4: %b", str3 == str4));

        System.out.println(String.format("str1.equals(str2): %b", str1.equals(str2)));
        System.out.println(String.format("str1.equals(str3): %b", str1.equals(str3)));
        System.out.println(String.format("str3.equals(str4): %b", str3.equals(str4)));

        Vector vec1 = new Vector(2, 5);
        Vector vec2 = new Vector(2, 5);
        Vector vec3 = vec2;

        System.out.println(String.format("vec1 == vec2: %b", vec1 == vec2));
        System.out.println(String.format("vec2 == vec3: %b", vec2 == vec3));
        System.out.println(String.format("vec1 == vec3: %b", vec1 == vec3));
    }
}
