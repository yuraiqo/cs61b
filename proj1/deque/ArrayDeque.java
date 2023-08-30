package deque;

public class ArrayDeque<T> {

    private T[] items = (T[]) new Object[8];
    private int size;
    private int first;
    private int last;

    /** Creates empty ArrayDeque. */
    public ArrayDeque() {
        size = 0;
        first = last = -1;
    }

    public void resize() {
        if (size == items.length) {
            return;
        }
    }

    /** Adds item to start of ArrayDeque. */
    public void addFirst(T item) {
        resize();
        if (first == -1 && last == -1) {
            first = last = 0;
            items[first] = item;
        } else if (first == 0) {
            first = items.length - 1;
            items[first] = item;
        } else {
            first -= 1;
            items[first] = item;
        }

    }

    /** Adds item to end of ArrayDeque. */
    public void addLast(T item) {
        resize();
        if (first == -1 && last == -1) {
            first = last = 0;
            items[last] = item;
        } else if (last == items.length - 1) {
            last = 0;
            items[last] = item;
        } else {
            last += 1;
            items[last] = item;
        }
    }

    /** Returns true if ArrayDeque is empty, otherwise returns false. */
    public boolean isEmpty() {
        return size <= 0;
    }

    /** Returns size of ArrayDeque. */
    public int size() {
        return size;
    }

    /** Prints formatted ArrayDeque. */
    public void printDeque() {
        int i = first;
        while (i != last) {
            System.out.print(items[i] + " ");
            i = (i + 1) % items.length;
        }
        System.out.print(items[last]);
        System.out.println();
    }

    /** Removes first item in ArrayDeque. */
    public T removeFirst() {
        T item = items[first];
        items[first] = null;
        first += 1;
        size -= 1;
        return item;
    }

    /** Removes last item in ArrayDeque. */
    public T removeLast() {
        T item = items[last];
        items[last] = null;
        last -= 1;
        size -= 1;
        return item;
    }

    /** Returns nth item in ArrayDeque. */
    public T get(int index) {
        if (index < 0 || index >= items.length) {
            return null;
        }
        return items[first + index];
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        list.addFirst(5);
        list.addFirst(1);
        list.addFirst(3);
        list.addLast(9);
        list.addFirst(10);
        list.printDeque();
    }
}
