package academy.pocu.comp2500samples.w13.stackusingcomposition;

import java.util.ArrayList;

public final class Stack<E> {
    private ArrayList<E> list = new ArrayList<>();

    public void push(E element) {
        this.list.add(element);
    }

    public E peek() {
        assert this.list.size() > 0;

        int lastIndex = this.list.size() - 1;
        E element = this.list.get(lastIndex);

        return element;
    }

    public E pop() {
        assert this.list.size() > 0;

        int lastIndex = this.list.size() - 1;
        E element = this.list.get(lastIndex);

        this.list.remove(lastIndex);

        return element;
    }
}
