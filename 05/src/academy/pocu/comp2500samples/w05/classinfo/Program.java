package academy.pocu.comp2500samples.w05.classinfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Program {
    public static void main(String[] args) {
        Vector vector = new Vector(2, 5);

        Class vectorClass = vector.getClass();

        System.out.printf("Package name: %s%s",
                vectorClass.getPackageName(),
                System.lineSeparator());

        System.out.printf("Type name: %s%s",
                vectorClass.getTypeName(),
                System.lineSeparator());

        Method[] methods = vectorClass.getMethods();

        System.out.printf("# methods: %d%s",
                methods.length,
                System.lineSeparator());

        methods = vectorClass.getDeclaredMethods();

        System.out.printf("# declared methods: %d%s",
                methods.length,
                System.lineSeparator());

        for (Method m: methods) {
            System.out.printf("    - %s%s",
                    m.getName(),
                    System.lineSeparator());
        }

        try {
            Method method = vectorClass
                    .getMethod("toString");

            System.out.println(method.toString());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            Method method = vectorClass
                    .getDeclaredMethod("toString");

            System.out.println(method.toString());
        } catch (NoSuchMethodException e) {
            System.out.println("No such method!");
        }

        try {
            Method method = vectorClass.getDeclaredMethod("changeName");

            System.out.println(method.toString());
        } catch (NoSuchMethodException e) {
            System.out.println("No such method!");
        }

        try {
            Method method = vectorClass.getDeclaredMethod("add", Vector.class);

            System.out.println(method.toString());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Field[] fields = vectorClass
                .getDeclaredFields();

        System.out.printf("# member vars: %d%s",
                fields.length,
                System.lineSeparator());

        Class objectClass = vectorClass
                .getSuperclass();

        System.out.printf("Superclass: %s%s",
                objectClass.getTypeName(),
                System.lineSeparator());
    }
}
