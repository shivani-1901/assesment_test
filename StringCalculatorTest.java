import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    void testEmptyString() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    void testSingleNumber() {
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    void testTwoNumbers() {
        assertEquals(6, StringCalculator.add("1,5"));
    }

    @Test
    void testNewLineDelimiter() {
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    void testCustomDelimiter() {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    void testNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("-1,2"));
    }

    @Test
    void testMultipleNegativeNumbers() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> StringCalculator.add("//|\n-1|3|-5"));
        assertEquals("Negative numbers not allowed: -1, -5", exception.getMessage());
    }
}