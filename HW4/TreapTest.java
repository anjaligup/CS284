package HW4.Gupta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TreapTest {
        // treap 1
        @Test
        void testTest1() {
            Treap test1 = new Treap<Integer>();

            test1.add(4, 19);
            test1.add(2, 31);
            test1.add(6, 70);
            test1.add(1, 84);
            test1.add(3, 12);
            test1.add(5, 83);
            test1.add(7, 26);


            // check if delete works when node to be deleted has one child
            boolean deleted = test1.delete(6);
            System.out.println("Element 6 deleted: " + deleted);
            assertEquals(deleted, true);


            // check if delete works when node to be deleted is a leaf
            deleted = test1.delete(3);
            System.out.println("Element 3 deleted: " + deleted);
            assertEquals(deleted, true); // Assertion


            deleted = test1.delete(4);
            System.out.println("Element 4 deleted: " + deleted);
            assertEquals(deleted, true); // Assertion

            boolean found  = test1.find(4);
            System.out.println("Element 4 found: " + found);
            assertEquals(found, false); // Assertion


            // Check if elements are found after deletion
            boolean notFound = test1.find(3);
            System.out.println("Element 3 found: " + notFound); // Print result
            assertEquals(notFound, false);  // Assertion

            notFound = test1.find(25);
            System.out.println("Element 25 found: " + notFound); // Print result
            assertEquals(notFound, false);


        }

        @Test
        void testTest2() {
            // treap 2
            Treap test2 = new Treap<Character>();

            test2.add('a', 30);
            test2.add('c', 2);
            test2.add('z', 40);
            test2.add('g', 10);
            test2.add('q', 5);
            test2.add('p', 25);

            boolean found = test2.find('a');
            System.out.println("'a' found: " + found);
            assertEquals(found, true);

            boolean deleted = test2.delete('p');
            System.out.println("'p' deleted: " + deleted);
            assertEquals(deleted, true);

            boolean notFound = test2.find('p');
            System.out.println("'p' found: " + notFound);
            assertEquals(notFound, false);
        }
    }

