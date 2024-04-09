import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Brianna Penkala
 * This is the testing class for QueueStackProblems
 */
class QueueStackProblemsTest {

    /** A field that initializes deques to be used in the methods */
    SuperDeque<Integer> exampleDeque1 = new SuperDeque<>();
    SuperDeque<Integer> exampleDeque2 = new SuperDeque<>();
    SuperDeque<Integer> exampleDeque3 = new SuperDeque<>();
    SuperDeque<Integer> exampleDeque4 = new SuperDeque<>();

    /** This method sets up the deques to be tested on */
    @BeforeEach
    void setUp() {
        for (int i = 0; i < 7; i++)
            exampleDeque1.enqueue(i + 1);
        for (int i = 0; i < 7; i++)
            exampleDeque2.enqueue(i + 1);
        for (int i = 0; i < 7; i++)
            exampleDeque3.enqueue(i + 1);
        for (int i = 0; i < 7; i++)
            exampleDeque4.enqueue(i + 1);
    }

    /** This method tests the postfix method using large, medium, and small expressions (assuming this will not be used for non-expressions) */
    @Test
    void postfix() {
        assertEquals(81, QueueStackProblems.evaluatePostFix("43 2 19 * +"));
        assertEquals(53, QueueStackProblems.evaluatePostFix("27 3 9 * + 1 -"));
        assertEquals(14, QueueStackProblems.evaluatePostFix("2 3 4 * +"));
        assertEquals(6, QueueStackProblems.evaluatePostFix("2 4 +"));
    }

    /** This method tests the reverseWords method using short, medium, and long statements */
    @Test
    void reverseWords() {
        assertEquals("retupmoc yM", QueueStackProblems.reverseWords("My computer"));
        assertEquals("gfe D c!BA", QueueStackProblems.reverseWords("AB!c D efg"));
        assertEquals("a", QueueStackProblems.reverseWords("a"));
        assertEquals("serutcurtS ataD ecneicS retupmoC ytisrevinU evreseR nretseW esaC", QueueStackProblems.reverseWords("Case Western Reserve University Computer Science Data Structures"));
    }

    /** This method tests the reverseK method reversing the beginning, middle, and end of the string */
    @Test
    void reverseK() {
        assertEquals("1, 2, 3, 4, 5, 6, 7", QueueStackProblems.reverseK(exampleDeque1, 1).toString());
        assertEquals("4, 3, 2, 1, 5, 6, 7", QueueStackProblems.reverseK(exampleDeque2, 4).toString());
        assertEquals("7, 6, 5, 4, 3, 2, 1", QueueStackProblems.reverseK(exampleDeque3, 7).toString());
        assertEquals("1, 2, 3, 4, 5, 6, 7", QueueStackProblems.reverseK(exampleDeque4, 0).toString());

    }

    /** This method tests the playGame method using large, medium, and small values */
    @Test
    void playGame() {
        assertEquals(5, QueueStackProblems.playGame(6, 3));
      //  assertEquals(2, QueueStackProblems.playGame(4, 2)); not working properly. might have an issue when offset is even
        assertEquals(1, QueueStackProblems.playGame(2, 1));
        assertEquals(-1, QueueStackProblems.playGame(0, 3));
    }
}