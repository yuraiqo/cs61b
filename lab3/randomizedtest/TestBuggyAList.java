package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        correct.addLast(5);
        correct.addLast(10);
        correct.addLast(15);

        broken.addLast(5);
        broken.addLast(10);
        broken.addLast(15);

        assertEquals(correct.size(), broken.size());

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> L2 = new BuggyAList<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                L2.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int size2 = L2.size();
                System.out.println("size: " + size + " size2: " + size2);
                assertEquals(size, size2);
            } else if (operationNumber == 2 && L.size() > 0 && L2.size() > 0) {
                // getLast
                int last = L.getLast();
                int last2 = L2.getLast();
                System.out.println("getLast: " + last + " getLast2: " + last2);
                assertEquals(last, last2);
            } else if (operationNumber == 3 && L.size() > 0 && L2.size() > 0) {
                // removeLast
                int removed = L.removeLast();
                int removed2 = L2.removeLast();
                System.out.println("removeLast: " + removed + " removeLast2: " + removed2);
                assertEquals(removed, removed2);
            }
        }
    }
}
