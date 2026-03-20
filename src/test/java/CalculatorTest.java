import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void addMe() {
        Calculator calculator = new Calculator();
        double result = calculator.addMe(2,3);
        assertEquals(5.0,result,0.01);

    }

    @Test
    public void subMe() {
        Calculator calculator = new Calculator();
        double result = calculator.subMe(5,3);
        assertEquals(2.0,result,0.01);
    }
}