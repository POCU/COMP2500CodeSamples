package academy.pocu.comp2500samples.w05.classinfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Program {
    public static void main(String[] args) {
        Vector vector = new Vector(2, 5);

        Class vectorClass = vector.getClass();

        System.out.printf("Package name: %s\n",
                vectorClass.getPackageName());

        System.out.printf("Type name: %s\n",
                vectorClass.getTypeName());

        Method[] methods = vectorClass.getMethods();

        System.out.printf("# methods: %d\n",
                methods.length);

        methods = vectorClass.getDeclaredMethods();

        System.out.printf("# declared methods: %d\n",
                methods.length);

        for (Method m: methods) {
            System.out.printf("    - %s\n",
                    m.getName());
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

        System.out.printf("# member vars: %d\n",
                fields.length);

        Class objectClass = vectorClass
                .getSuperclass();

        System.out.printf("Superclass: %s\n",
                objectClass.getTypeName());
    }
}
