package exercises_tests;

import exercises.Bagel;
import exercises.BagelSolver;
import org.junit.Test;

public class BagelTest {
    @Test
    public void testBagel() {
        Bagel bagel = BagelSolver.getBagel();

        System.out.println(bagel.getValue());
        org.junit.Assert.assertEquals(
                bagel.getValue() == 4,
                java.lang.Boolean.TRUE
        );
    }
}
