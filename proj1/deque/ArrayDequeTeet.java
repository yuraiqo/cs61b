package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTeet {

    @Test
    public void nonEmptyInstantiationTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst(5);

        assertFalse("Should not be empty", arrayDeque.isEmpty());
        assertEquals("Should have size 1", 1, arrayDeque.size());
    }
}
