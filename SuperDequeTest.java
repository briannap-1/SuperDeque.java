import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Brianna Penkala
 * This is the testing class for SuperDeque
 */
class SuperDequeTest {

    /** These are various implementations of SuperDeque that use both stack and queue operations */
    private SuperDeque<Integer> superDeque = new SuperDeque<>();
    private SuperDeque<Integer> exampleDeque = new SuperDeque<>();
    private SuperDeque<Integer> queueExample = new SuperDeque<>();

    /** This method sets up the deques to be tested on */
    @BeforeEach
    public void setUp() {
        exampleDeque.push(5);
        exampleDeque.push(9);
        exampleDeque.push(1);
        //"1, 9, 5"
        queueExample.enqueue(7);
        queueExample.enqueue(8);
        queueExample.enqueue(9);
        //"7, 8, 9"
    }

    /** This method tests the getDQLength method */
    @Test
    void getDQLength() {
        assertEquals(4, queueExample.getDQLength());
        exampleDeque.push(6);
        exampleDeque.push(7);
        assertEquals(8, exampleDeque.getDQLength());
    }

    /** This method tests the push method */
    @Test
    void push() {
        assertEquals("1, 9, 5", exampleDeque.toString());
        superDeque.push(4);
        superDeque.push(8);
        superDeque.push(3);
        superDeque.push(7);
        //"7, 3, 8, 4"
        assertEquals("7, 3, 8, 4", superDeque.toString());
        assertEquals("7, 8, 9", queueExample.toString());
    }

    /** This method tests the pop method */
    @Test
    void pop() {
        assertEquals(1, exampleDeque.pop());
        assertEquals(7, queueExample.pop());
    }

    /** This method tests the peek method */
    @Test
    void peek() {
        assertEquals(1, exampleDeque.peek());
        assertEquals(7, queueExample.peek());
    }

    /** This method tests the enqueue method */
    @Test
    void enqueue() {
        exampleDeque.enqueue(2);
        assertEquals("1, 9, 5, 2", exampleDeque.toString());
        assertEquals(7, queueExample.peek()); //(item was enqueued onto queueExample, verifying it was added)
    }

    /** This method tests the dequeue method */
    @Test
    void dequeue() {
        queueExample.dequeue();
        assertEquals("8, 9", queueExample.toString());
    }

    /** This method tests the isEmpty method */
    @Test
    void isEmpty() {
        assertFalse(exampleDeque.isEmpty());
        assertFalse(queueExample.isEmpty());
    }

    /** This method tests the toString method */
    @Test
    void testToString() {
        assertEquals("1, 9, 5", exampleDeque.toString());
        assertEquals("7, 8, 9", queueExample.toString());
    }
}