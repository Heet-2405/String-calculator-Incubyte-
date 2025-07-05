import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Test_Calculator {
    Calculator calculator = new Calculator();

    @Test
    public void emptyString() {
        assertEquals(0 ,calculator.Add(""));
    }

    @Test
    public void testSingleNumber() {
        assertEquals(1, calculator.Add("1"));
    }

    @Test
    public void testTwoNumbers() {
        assertEquals(3, calculator.Add("1,2"));
    }

    @Test
    public void testMultipleNumbers() {
        assertEquals(10, calculator.Add("1,2,3,4"));
    }

    @Test
    public void testNewlineAsDelimiter() {
        assertEquals(6, calculator.Add("1\n2,3"));
    }

    @Test
    public void testCustomDelimiter() {
        assertEquals(3, calculator.Add("//;\n1;2"));
    }

    @Test
    public void testNegativeNumberThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            calculator.Add("1,-2,-5");
        });
        assertTrue(ex.getMessage().contains("-2"));
        assertTrue(ex.getMessage().contains("-5"));
        System.out.println(ex.getMessage());
    }

    @Test
    public void testNumbersGreaterThan1000AreIgnored() {
        assertEquals(2, calculator.Add("2,1001"));
    }

    @Test
    public void testMultiCharDelimiter() {
        assertEquals(6, calculator.Add("//[***]\n1***2***3"));
    }


    @Test
    public void testCallCount() {
        calculator.Add("1,2");
        calculator.Add("3,4");
        assertEquals(2, calculator.GetCalledCount());
    }

}
