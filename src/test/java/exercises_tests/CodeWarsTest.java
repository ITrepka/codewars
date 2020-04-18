package exercises_tests;

import exercises.CodeWars;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CodeWarsTest {
    @Test
    public void testSomething() {
        assertEquals(1, CodeWars.strCount("Hello", 'o'));
        assertEquals(2, CodeWars.strCount("Hello", 'l'));
        assertEquals(0, CodeWars.strCount("",'z'));
    }
}
