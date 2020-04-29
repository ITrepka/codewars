package exercises_tests;

import exercises.SquareSum;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SquareSumTest {
    @Test
    public void testBasic()
    {
        assertEquals(9, SquareSum.squareSum(new int[] {1,2,2}));
        assertEquals(5, SquareSum.squareSum(new int[] {1,2}));
        assertEquals(50, SquareSum.squareSum(new int[] {5,-3,4}));
    }
}
