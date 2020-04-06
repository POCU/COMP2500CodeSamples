package academy.pocu.comp2500samples.w07.entitycomponentsystem;

import java.util.ArrayList;

public class GameObject {
    private String name;
    private ArrayList<Component> components = new ArrayList<Component>();

    public GameObject(String name) {
        this.name = name;
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void update() {
        System.out.printf("Update GameObject '%s'\n", this.name);

        for (Component component : this.components) {
            component.update();
        }

        System.out.printf("Updating '%s' complete\n", this.name);
    }
}
