package academy.pocu.comp2500samples.w13.stackusinginheritance;

import java.util.ArrayList;

public final class Stack<E> extends ArrayList<E> {
    public void push(E element) {
        this.add(element);
    }

    public E peek() {
        assert this.size() > 0;

        int lastIndex = this.size() - 1;
        E element = this.get(lastIndex);

        return element;
    }

    public E pop() {
        assert this.size() > 0;

        int lastIndex = this.size() - 1;
        E element = this.get(lastIndex);

        this.remove(lastIndex);

        return element;
    }
}
