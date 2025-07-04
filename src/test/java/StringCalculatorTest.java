import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator calc = new StringCalculator();

    @Test                                                           // For the empty string                                                  
    void testEmptyStringReturnsZero() {
        assertEquals(0, calc.add(""));
    }

    @Test                                                           // For Null input As string
    void testNullStringReturnsZero() {
        assertEquals(0, calc.add(null));
    }

    @Test                                                           // For the simple Number String 
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

    @Test                                                           // For Any Amount of numbers
    void testAnyAmountOfNumbers() {
        assertEquals(510, calc.add("1,2,3,4,500"));
        assertEquals(10045, calc.add("1,2,3,4,5,6,7,8,9,10000"));
    }

    @Test                                                           // For handling new lines between numbers (instead of commas)
    void testNewlineAsDelimiter() {
        assertEquals(6, calc.add("1\n2,3"));
        assertEquals(10, calc.add("1\n2\n3,4"));
    }

    @Test                                                           // For changing the delimiter, the beginning of the string 
    void testCustomDelimiter() {
        assertEquals(4, calc.add("//;\n2;2"));
        assertEquals(7, calc.add("//-\n2-2-3"));
    }

    @Test                                                           // For The negetive number in string which gave the exception
    void testNegativeNumbersThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            calc.add("1,-5,3,-6");
        });
        assertTrue(ex.getMessage().contains("negative numbers not allowed"));
        assertTrue(ex.getMessage().contains("-5"));
        assertTrue(ex.getMessage().contains("-6"));
    }


}
