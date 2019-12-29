package exercises_tests;

import static org.junit.Assert.*;

import exercises.Keypad;
import org.junit.Test;

public class KeypadTest {
    @Test
    public void simpleTest() {
        assertEquals(9, Keypad.presses("LOL"));
        assertEquals(13, Keypad.presses("HOW R U"));
    }
}
