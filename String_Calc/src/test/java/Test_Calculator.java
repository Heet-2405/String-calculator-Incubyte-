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









}
