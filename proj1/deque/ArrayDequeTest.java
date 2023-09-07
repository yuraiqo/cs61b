package deque;

import org.junit.Test;
import static org.junit.Assert.*;

/** Performs some basic linked list tests. */
public class ArrayDequeTest {

    @Test
    /* Adds a few things to the list, checking if isEmpty() and size() are correct. */
    public void addIsEmptySizeTest() {
        ArrayDeque<String> list1 = new ArrayDeque<>();
        assertTrue("A newly initialized AList should be empty", list1.isEmpty());

        ArrayDeque<String> list2 = new ArrayDeque<>();
        list2.addLast("one");
        assertFalse("list2 should contain 1 item", list2.isEmpty());

        list2.addFirst("two");
        assertEquals(2, list2.size());
    }

    @Test
    /* Adds an item, then removes an item, and ensures that dll is empty afterward. */
    public void addRemoveTest() {
        ArrayDeque<Integer> list1 = new ArrayDeque<>();
        assertTrue("lld1 should be empty upon initialization", list1.isEmpty());

        list1.addFirst(10);
        assertFalse("lld1 should contain 1 item", list1.isEmpty());

        list1.removeFirst();
        assertTrue("lld1 should be empty after removal", list1.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque. */
    public void removeEmptyTest() {
        ArrayDeque<Integer> list1 = new ArrayDeque<>();
        assertTrue("list1 should be empty upon initialization", list1.isEmpty());

        list1.addFirst(10);
        assertFalse("list1 should contain 1 item", list1.isEmpty());

        list1.removeFirst();
        assertTrue("list1 should be empty after removal", list1.isEmpty());
    }

    @Test
    /* Check if you can create ArrayDeque with different parameterized types*/
    public void multipleParamTest() {
        ArrayDeque<String>  list1 = new ArrayDeque<>();
        ArrayDeque<Double>  list2 = new ArrayDeque<>();
        ArrayDeque<Boolean> list3 = new ArrayDeque<>();

        list1.addFirst("string");
        list2.addFirst(3.14159);
        list3.addFirst(true);

        String s = list1.removeFirst();
        double d = list2.removeFirst();
        boolean b = list3.removeFirst();

    }

    @Test
    /* Check if null is return when removing from an empty ArrayDeque. */
    public void emptyNullReturnTest() {
        ArrayDeque<Integer> list1 = new ArrayDeque<>();

        assertNull("Should return null when removeFirst is called on an empty Deque,", list1.removeFirst());
        assertNull("Should return null when removeLast is called on an empty Deque,", list1.removeLast());
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {
        ArrayDeque<Integer> list1 = new ArrayDeque<>();
        for (int i = 0; i < 1000000; i++) {
            list1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) list1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) list1.removeLast(), 0.0);
        }
    }
}
