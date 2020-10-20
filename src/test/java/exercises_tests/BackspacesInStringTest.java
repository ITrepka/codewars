package exercises_tests;

import exercises.BackspacesInString;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackspacesInStringTest {
    @Test
    public void testCleanString() {
        final BackspacesInString bis = new BackspacesInString();
        assertEquals("ac", bis.cleanString("abc#d##c"));
        assertEquals("", bis.cleanString("abc####d##c#"));
    }
}
