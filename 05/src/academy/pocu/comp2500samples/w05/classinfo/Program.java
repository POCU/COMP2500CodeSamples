package academy.pocu.comp2500samples.w05.classinfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Program {
    public static void main(String[] args) {
        Vector vector = new Vector(2, 5);

        Class vectorClass = vector.getClass();

        System.out.println(String.format(
                "Package name: %s",
                vectorClass.getPackageName()
        ));

        System.out.println(String.format(
                "Type name: %s",
                vectorClass.getTypeName()
        ));

        Method[] methods = vectorClass.getMethods();
        System.out.println(String.format(
                "Total # methods: %d",
                methods.length
        ));

        methods = vectorClass.getDeclaredMethods();
        System.out.println(String.format(
                "Total # declared methods: %d",
                methods.length
        ));

        for (Method m: methods) {
            System.out.println(String.format(
                    "    - %s",
                    m.getName()
            ));
        }

        try {
            Method method = vectorClass.getMethod("toString");
            System.out.println(method.toString());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            Method method = vectorClass.getDeclaredMethod("toString");
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

        try {
            Method method = vectorClass.getDeclaredMethod("changeName");
            System.out.println(method.toString());
        } catch (NoSuchMethodException e) {
            System.out.println("No such method!");
        }

        Field[] fields = vectorClass.getDeclaredFields();

        System.out.println(String.format(
                "Total # declared fields: %d",
                fields.length
        ));

        Class objectClass = vectorClass.getSuperclass();

        System.out.println(String.format(
                "Superclass: %s",
                objectClass.getTypeName()
        ));
    }
}
