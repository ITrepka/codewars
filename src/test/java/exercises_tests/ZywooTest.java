package exercises_tests;

import exercises.Zywoo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZywooTest {
    @Test
    public void testSomething() {
        Zywoo zywoo = new Zywoo();
        assertEquals("Oi! Sheep number 2! You are about to be eaten by a wolf!", zywoo.warnTheSheep(new String[]{"sheep", "sheep", "sheep", "sheep", "sheep", "wolf", "sheep", "sheep"}));
        assertEquals("Oi! Sheep number 5! You are about to be eaten by a wolf!", zywoo.warnTheSheep(new String[]{"sheep", "wolf", "sheep", "sheep", "sheep", "sheep", "sheep"}));
        assertEquals("Oi! Sheep number 6! You are about to be eaten by a wolf!", zywoo.warnTheSheep(new String[]{"wolf", "sheep", "sheep", "sheep", "sheep", "sheep", "sheep"}));
        assertEquals("Oi! Sheep number 1! You are about to be eaten by a wolf!", zywoo.warnTheSheep(new String[]{"sheep", "wolf", "sheep"}));
        assertEquals("Pls go away and stop eating my sheep", zywoo.warnTheSheep(new String[]{"sheep", "sheep", "wolf"}));
    }
}
