package exercises_tests;

import exercises.DivisibleNb;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DivisibleNbTest {
    @Test
    public void test1() {
        assertEquals(true, DivisibleNb.isDivisible(12,4,3));
    }
    @Test
    public void test2() {
        assertEquals(false, DivisibleNb.isDivisible(3,3,4));
    }
}
