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






}
