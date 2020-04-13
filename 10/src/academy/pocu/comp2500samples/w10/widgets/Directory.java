package academy.pocu.comp2500samples.w10.widgets;

public final class Directory extends Widget implements IClickable, IDraggable, IDroppable {
    public Directory(int x, int y) {
        super(x, y);
    }

    public Directory(String label, int x, int y) {
        super(label, x, y);
    }

    @Override
    public void onClick() {
        System.out.printf("Directory %s clicked!%s",
                this.label,
                System.lineSeparator());
    }

    @Override
    public void onDrag(int x, int y) {
        System.out.printf("Drag Directory %s from [ %d, %d ] -> [ %d, %d ]!%s",
                this.label,
                this.x,
                this.y,
                x,
                y,
                System.lineSeparator());

        this.x = x;
        this.y = y;
    }

    @Override
    public void onDrop(Widget widget) {
        System.out.printf("Widget %s was dropped inside of Directory %s%s",
                widget.getLabel(),
                this.label,
                System.lineSeparator());
    }
}
