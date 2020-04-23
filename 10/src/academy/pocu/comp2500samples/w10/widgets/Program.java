package academy.pocu.comp2500samples.w10.widgets;

import java.util.ArrayList;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        final Button button1 = new Button("Button1", 10, 5);
        final Button button2 = new Button("Button2", 5, 0);

        final Card card1 = new Card("Card1", 0, 1);
        final Card card2 = new Card("Card2", -10, -1);

        final Directory directory1 = new Directory("New Folder1", 5, 9);
        final Directory directory2 = new Directory("New Folder2", 12, 22);

        final ArrayList<Widget> widgets = new ArrayList<>();

        widgets.add(button1);
        widgets.add(button2);
        widgets.add(card1);
        widgets.add(card2);
        widgets.add(directory1);
        widgets.add(directory2);

        for (Widget widget : widgets) {
            System.out.printf("Widget label: %s%s",
                    widget.getLabel(),
                    System.lineSeparator());

            // Compile Error
            // widget.onClick();
            // widget.onDrag(10, 14);
            // widget.onDropped(card1);
        }

        final IClickable clickableButton = (IClickable) widgets.get(0);
        clickableButton.onClick();

        System.out.println("----------------");

        final ArrayList<IClickable> clickables = new ArrayList<>();

        clickables.add(button1);
        clickables.add(button2);
        clickables.add(directory1);
        clickables.add(directory2);

        // Compile Error
        // clickables.add(card1);

        // Compile error
        // clickables.add((IClickable) card2);

        for (IClickable clickable : clickables) {
            clickable.onClick();
        }

        System.out.println("----------------");

        final ArrayList<IDraggable> draggables = new ArrayList<>();

        draggables.add(card1);
        draggables.add(card2);
        draggables.add(directory1);
        draggables.add(directory2);

        final Random random = new Random(10);

        for (IDraggable draggable : draggables) {
            int x = random.nextInt(50);
            int y = random.nextInt(50);

            draggable.onDrag(x, y);
        }

        System.out.println("----------------");

        final ArrayList<IDroppable> droppables = new ArrayList<>();

        droppables.add(directory1);
        droppables.add(directory2);

        for (IDroppable droppable : droppables) {
            droppable.onDrop(button1);
        }
    }
}
