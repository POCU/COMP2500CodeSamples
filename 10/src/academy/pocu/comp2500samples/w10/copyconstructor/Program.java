package academy.pocu.comp2500samples.w10.copyconstructor;

public class Program {
    public static void main(String[] args) {
        final Point p1 = new Point(1, 1);
        final Point p2 = new Point(p1);

        p1.setX(-4);
        p1.setY(-8);

        System.out.printf("p1.x: %d, p1.y: %d%s",
                p1.getX(),
                p1.getY(),
                System.lineSeparator());
        System.out.printf("p2.x: %d, p2.y: %d%s",
                p2.getX(),
                p2.getY(),
                System.lineSeparator());

        final Point p3 = new Point(5, 7);

        final Line l1 = new Line(p2, p3);
        final Line l2 = new Line(l1);

        p2.setX(10);
        p2.setY(15);

        System.out.printf("l1.p1.x: %d, l1.p1.y: %d%s",
                l1.getP1().getX(),
                l1.getP1().getY(),
                System.lineSeparator());

        System.out.printf("l1.p2.x: %d, l1.p2.y: %d%s",
                l1.getP2().getX(),
                l1.getP2().getY(),
                System.lineSeparator());

        System.out.printf("l2.p1.x: %d, l2.p1.y: %d%s",
                l2.getP1().getX(),
                l2.getP1().getY(),
                System.lineSeparator());

        System.out.printf("l2.p2.x: %d, l2.p2.y: %d%s",
                l2.getP2().getX(),
                l2.getP2().getY(),
                System.lineSeparator());
    }
}
