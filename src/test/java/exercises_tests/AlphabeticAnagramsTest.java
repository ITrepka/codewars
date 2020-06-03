package exercises_tests;

import exercises.AlphabeticAnagrams;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


import java.math.BigInteger;

public class AlphabeticAnagramsTest {
    @Test
    public void testKnownInputs() {
        AlphabeticAnagrams anagram = new AlphabeticAnagrams();

        assertEquals("Position for 'A' incorrect", BigInteger.ONE, anagram.listPosition("A"));
        assertEquals("Position for 'ABAB' incorrect", BigInteger.valueOf(2), anagram.listPosition("ABAB"));
        assertEquals("Position for 'AAAB' incorrect", BigInteger.ONE, anagram.listPosition("AAAB"));
        assertEquals("Position for 'BAAA' incorrect", BigInteger.valueOf(4), anagram.listPosition("BAAA"));
        assertEquals("Position for 'QUESTION' incorrect", BigInteger.valueOf(24572), anagram.listPosition("QUESTION"));
        assertEquals("Position for 'BOOKKEEPER' incorrect", BigInteger.valueOf(10743), anagram.listPosition("BOOKKEEPER"));
    }
}
