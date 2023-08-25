package deque;

public class LinkedListDeque<T> {

    private class TypeNode {
        public T item;
        public TypeNode next;

        public TypeNode(T i, TypeNode n) {
            item = i;
            next = n;
        }
    }

    private TypeNode sentinel;
    private int size;

    /** Creates empty LinkedListDeque. */
    public LinkedListDeque() {

    };

    /** Creates LinkedListDeque. */
    public LinkedListDeque(T x) {
    }

    /** Adds item to start of LinkedListDeque. */
    public void addFirst(T item) {
        sentinel.next = new TypeNode(item, null);
        size += 1;
    };

    /** Adds item to end of LinkedListDeque. */
    public void addLast(T item) {
        size += 1;
    };

    /** Returns true if LinkedListDeque is empty, otherwise returns false. */
    public boolean isEmpty() {
        if (size == 0) {
            return false;
        };
        return true;
    };

    /** Returns size of LinkedListDeque. */
    public int size() {
        return size;
    };

    /** Prints formatted LinkedListDeque. */
    public void printDeque() {};

    /** Removes first item in LinkedListDeque. */
    public T removeFirst() {
        return null;
    };

    /** Removes last item in LinkedListDeque. */
    public T removeLast() {
        return null;
    };

    /** Returns nth item in LinkedListDeque. */
    public T get(int index) {
        return null;
    };
}
