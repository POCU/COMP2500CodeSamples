package academy.pocu.comp2500samples.w07.graphics;

public class Circle extends Graphic {
    private Point center;
    private int radius;

    public Circle(String label,
                  Point center,
                  int radius) {
        super(label);
        this.center = center;
        this.radius = radius;
    }

    public double getCircumference() {
        return 2 * radius * Math.PI;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public void draw() {
        System.out.printf("Draw circle '%s'\n", this.label);
    }
}
