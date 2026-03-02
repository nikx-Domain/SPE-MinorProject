import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    
    @Test
    public void testSquareRoot() {
        assertEquals(4.0, Math.sqrt(16.0), 0.001);
    }

    @Test
    public void testFactorial() {
        assertEquals(120.0, ScientificCalculator.factorial(5), 0.001);
        assertEquals(1.0, ScientificCalculator.factorial(0), 0.001);
    }

    @Test
    public void testNaturalLog() {
        assertEquals(1.0, Math.log(Math.E), 0.001);
    }

    @Test
    public void testPower() {
        assertEquals(8.0, Math.pow(2.0, 3.0), 0.001);
    }
}
