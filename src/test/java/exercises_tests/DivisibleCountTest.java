package exercises_tests;

import exercises.DivisibleCount;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DivisibleCountTest {
    @Test
    public void testSomething() {
        assertEquals(3, DivisibleCount.divisibleCount(6, 11, 2));
    }
}
