package deque;

public class LinkedListDeque<T> {

    private class TypeNode {
        public TypeNode prev;
        public T item;
        public TypeNode next;

        public TypeNode(TypeNode p, T i, TypeNode n) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private TypeNode sentinel;
    private int size;

    /** Creates empty LinkedListDeque. */
    public LinkedListDeque() {
        sentinel = new TypeNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /** Creates LinkedListDeque. */
    public LinkedListDeque(T x) {
        sentinel = new TypeNode(null, null, null);
        sentinel.next = new TypeNode(sentinel, x, sentinel);
        sentinel.prev = sentinel.next;
        size += 1;
    }

    /** Adds item to start of LinkedListDeque. */
    public void addFirst(T item) {
        sentinel.next = new TypeNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    /** Adds item to end of LinkedListDeque. */
    public void addLast(T item) {
        sentinel.prev = new TypeNode(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    /** Returns true if LinkedListDeque is empty, otherwise returns false. */
    public boolean isEmpty() {
        return size <= 0;
    }

    /** Returns size of LinkedListDeque. */
    public int size() {
        return size;
    }

    /** Prints formatted LinkedListDeque. */
    public void printDeque() {
        for (TypeNode temp = sentinel.next; temp != sentinel; temp = temp.next) {
            System.out.print(temp.item + " ");
        }
        System.out.println();
    }

    /** Removes first item in LinkedListDeque. */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        TypeNode first = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return first.item;
    }

    /** Removes last item in LinkedListDeque. */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        TypeNode last = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return last.item;
    }

    /** Returns nth item in LinkedListDeque. */
    public T get(int index) {
        if (index >= 0 && index < size) {
            TypeNode temp = sentinel.next;
            while (index > 0) {
                temp = temp.next;
                index -= 1;
            }
            return temp.item;
        } else {
            return null;
        }
    }

    private T getRecursiveHelper(int index, TypeNode t) {
        if (index == 0) {
            return t.item;
        } else {
            return getRecursiveHelper(index - 1, t.next);
        }
    }

    /** Returns nth item in LinkedListDeque using recursion. */
    public T getRecursive(int index) {
        if (index >= 0 && index < size) {
            return getRecursiveHelper(index, sentinel.next);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> list = new LinkedListDeque<>();
        System.out.println(list.size());
    }
}
