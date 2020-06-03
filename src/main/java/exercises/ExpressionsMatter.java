package exercises;

public class ExpressionsMatter {
    public static int expressionsMatter(int a, int b, int c)
    {
        return findMax(a,b,c);
    }

    private static int findMax(int a, int b, int c) {
        int res1 = a + b + c;
        int res2 = a * b * c;
        int res3 = a * (b + c);
        int res4 = (a + b) * c;
        return Integer.max(Integer.max(res1, res2), Integer.max(res3, res4));
    }
}
