package deque;

public class ArrayDeque<T> {
    private T[] items = (T[]) new Object[8];
    private int size;
    private int first;
    private int last;

    public ArrayDeque() {
        size = 0;
        first = 0;
        last = items.length - 1;
    }

    public void resize() {
        if (size == items.length) {
            return;
        }
    }

    public void addFirst(T item) {
        size += 1;
        resize();
        first = (first == 0) ? size : first - 1;
    }

    public void addLast(T item) {
        size += 1;
        resize();
        last = (last + 1 == size) ? 0 : last + 1;
        items[last] = item;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        return;
    }

    public T removeFirst() {}

    public T removeLast() {}

    public T get(int index) {}
}
