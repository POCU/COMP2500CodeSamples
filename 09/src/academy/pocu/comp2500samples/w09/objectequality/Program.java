package academy.pocu.comp2500samples.w09.objectequality;

import java.util.HashSet;

public class Program {
    public static void main(String[] args) {
        Point p1 = new Point(4, 1);
        Point p2 = p1;

        Point p3 = new Point(4, 1);
        Point p4 = new Point(9, 11);

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));

        System.out.println(p1 == p3);
        System.out.println(p1.equals(p3));

        Line l1 = new Line(p1, p4);
        Line l2 = new Line(p1, p4);

        System.out.println(l1 == l2);
        System.out.println(l1.equals(l2));

        Point p5 = new Point(4, 1);
        Point p6 = new Point(9, 11);

        Line l3 = new Line(p5, p6);

        System.out.println(l1.equals(l3));

        HashSet<Point> points = new HashSet<>();

        points.add(p1);
        System.out.println(points.contains(p3));
    }
}
