package exercises_tests;

import exercises.Psychic;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PsychicTest {
    @Test
    public void testRandom(){
        assertEquals(Psychic.guess(), java.lang.Math.random(), 0);
    }
}
