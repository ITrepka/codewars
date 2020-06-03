package exercises_tests;

import exercises.BreakCamelCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BreakCamelCaseTest {
    @Test
    public void tests() {
        assertEquals( "Incorrect", "camel Casing", BreakCamelCase.camelCase("camelCasing"));
        assertEquals( "Incorrect", "camel Casing Test", BreakCamelCase.camelCase("camelCasingTest"));
        assertEquals( "Incorrect", "camelcasingtest", BreakCamelCase.camelCase("camelcasingtest"));
    }
}
