package exercises;

public class Solution {
    public static int[] twoSum(int[] numbers, int target)
    {
        if (numbers == null) return null;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
