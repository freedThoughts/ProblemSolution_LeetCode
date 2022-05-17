package problemSet_1;
// https://leetcode.com/problems/integer-break/submissions/
public class IntegerBreak {

    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n%3 == 0) return (int) Math.pow(3, n/3);
        if (n%3 == 2) return (int) Math.pow(3, n/3) *2;
        return (int) Math.pow(3, n/3-1) * 4;
    }
}
