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
        assertEquals(1045, calc.add("1,2,3,4,5,6,7,8,9,1000"));
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

    @Test                                                               // For Value is greater than 1000
    void testNumbersGreaterThan1000AreIgnored() {
        assertEquals(2, calc.add("2,1001"));
        assertEquals(1002, calc.add("2,1000"));
        assertEquals(2, calc.add("2,1001,2000,3000"));
    }

    @Test                                                           // For Delimiters can be of any length
    void testCustomDelimiterOfAnyLength() {
        assertEquals(6, calc.add("//[***]\n1***2***3"));
        assertEquals(10, calc.add("//[abc]\n1abc2abc3abc4"));
    }

    @Test                                                           // For Allowing multiple delimiters
    void testMultipleDelimiters() {
        assertEquals(6, calc.add("//[*][%]\n1*2%3"));
        assertEquals(10, calc.add("//[abc][def]\n1abc2def3abc4"));
    }

    @Test                                                          // for handing multiple delimiters
    void testMultipleDelimitersOfAnyLength() {
        assertEquals(6, calc.add("//[***][%%]\n1***2%%3"));
        assertEquals(15, calc.add("//[abc][defg]\n1abc2defg3abc4defg5"));
    }

}
