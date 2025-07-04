import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator calc = new StringCalculator();

    @Test
    void testEmptyStringReturnsZero() {
        assertEquals(0, calc.add(""));
    }

    @Test
    void testNullStringReturnsZero() {
        assertEquals(0, calc.add(null));
    }

    @Test
    void testSingleNumberReturnsItself() {
        assertEquals(1, calc.add("1"));
        assertEquals(42, calc.add("42"));
    }

    @Test
    void testTwoNumbersSum() {
        assertEquals(3, calc.add("1,2"));
        assertEquals(7, calc.add("3,4"));
    }

    @Test
    void testMultipleNumbersSum() {
        assertEquals(6, calc.add("1,2,3"));
        assertEquals(15, calc.add("1,2,3,4,5"));
    }

    @Test
    void testNumbersWithSpaces() {
        assertEquals(6, calc.add(" 1 , 2 , 3 "));
    }
}
