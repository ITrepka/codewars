package exercises_tests;

import exercises.PointsInSegments;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PointsInSegmentsTest {
    @Test
    public void exampleTests() {
        assertArrayEquals(new int[]{0, 3, 4}, PointsInSegments.segments(5, new int[][] {{2, 2}, {1, 2}, {5, 5}}));
        assertArrayEquals(new int[0], PointsInSegments.segments(7, new int[][] {{0,7}}));
    }
}
