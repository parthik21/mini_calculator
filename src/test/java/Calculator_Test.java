import org.junit.*;

import static org.junit.Assert.*;

public class Calculator_Test {
    double delta = 1e-5;
    Calculations calculations = new Calculations();

    @Test
    public void sqrootTruePositiveAndNegative(){
        System.out.println("True Positive squareRoot test case check");
        assertEquals(4,calculations.squareRoot(16),delta);
        System.out.println("True Negative squareRoot test case check");
        assertNotEquals(3,calculations.squareRoot(10),delta);
    }

    @Test
    public void factorialTruePositiveAndNegative(){
        System.out.println("True Positive factorial test case check");
        assertEquals(120,calculations.factorial(5),delta);
        System.out.println("True Negative factorial test case check");
        assertNotEquals(28,calculations.factorial(4),delta);
    }

    @Test
    public void naturalLogTruePositiveAndNegative(){
        System.out.println("True Positive naturalLog test case check");
        assertEquals(1,calculations.naturalLog(Math.E),delta);
        System.out.println("True Negative naturalLog test case check");
        assertNotEquals(3,calculations.naturalLog(10),delta);
    }

    @Test
    public void powerTruePositiveAndNegative(){
        System.out.println("True Positive powerFunction test case check");
        assertEquals(100,calculations.powerFunction(10,2),delta);
        System.out.println("True Negative powerFunction test case check");
        assertNotEquals(28,calculations.powerFunction(3,3),delta);
    }
}
