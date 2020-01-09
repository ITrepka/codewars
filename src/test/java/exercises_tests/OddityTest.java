package exercises_tests;

import exercises.Oddity;
import org.junit.Test;
import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class OddityTest {

    @Test
    public void exampleTests() {
        assertEquals("odd", Oddity.oddity(BigInteger.valueOf(4)));
        assertEquals("even", Oddity.oddity(BigInteger.valueOf(12)));
    }
}
