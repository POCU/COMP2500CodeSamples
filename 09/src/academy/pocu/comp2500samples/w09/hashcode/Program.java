package academy.pocu.comp2500samples.w09.hashcode;

import java.util.HashSet;

public class Program {
    public static void main(String[] args) {
        HashSet<Point> points = new HashSet<>();

        Point p1 = new Point(1, 7);
        Point p2 = new Point(1, 7);
        Point p3 = new Point(7, 1);

        points.add(p1);

        System.out.println(points.contains(p2));
        System.out.println(points.contains(p3));

        HashSet<Line> lines = new HashSet<>();

        Line l1 = new Line(p1, p3);

        Point p4 = new Point(1, 7);
        Point p5 = new Point(7, 1);

        Line l2 = new Line(p4, p5);

        lines.add(l1);
        System.out.println(lines.contains(l2));

        Line l3 = new Line(p5, p4);
        System.out.println(lines.contains(l3));
    }
}
