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

        if (count > 0) {
            System.out.println(String.format(
                    "Draw picture %s",
                    this.label));

            for (int i = 0; i < count; ++i) {
                System.out.println(String.format(
                        "    %d. Draw picture %s",
                        i + 1,
                        this.label));
            }
        }
    }
}
