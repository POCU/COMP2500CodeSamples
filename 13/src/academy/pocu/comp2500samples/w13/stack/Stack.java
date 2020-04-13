package academy.pocu.comp2500samples.w13.stack;

import java.util.ArrayList;

public final class Stack<E> extends ArrayList<E> {
    @Override
    public void add(int index, E element) {
        super.add(element);
    }

    @Override
    public E remove(int index) {
        assert this.size() > 0;

        int lastIndex = size() - 1;
        E element = get(lastIndex);

        super.remove(lastIndex);

        return element;
    }

    @Override
    public boolean remove(Object o) {
        if (this.size() == 0) {
            return false;
        }

        remove(0);

        return true;
    }
}
