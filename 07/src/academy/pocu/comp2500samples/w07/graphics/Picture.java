package academy.pocu.comp2500samples.w07.graphics;

import java.util.ArrayList;

public class Picture extends Graphic {
    private ArrayList<Graphic> graphics;

    public Picture(String label) {
        super(label);
        
        this.graphics = new ArrayList<>();
    }

    public void add(Graphic graphic) {
        this.graphics.add(graphic);
    }

    public void draw() {
        int count = this.graphics.size();

        if (count <= 0) {
            return;
        }

        System.out.println(String.format("Draw picture '%s'",
                this.label));

        for (int i = 0; i < count; ++i) {
            Graphic g = this.graphics.get(i);
            Class c = g.getClass();
            String className = c.getSimpleName();

            switch (className) {
                case "Circle":
                    ((Circle) g).draw();
                    break;

                case "Point":
                    ((Point) g).draw();
                    break;

                case "Line":
                    ((Line) g).draw();
                    break;

                case "Picture":
                    ((Picture) g).draw();
                    break;

                default:
                    String message = String.format("Unknown graphic type %s", className);
                    throw new IllegalArgumentException(message);
            }
        }
    }
}
