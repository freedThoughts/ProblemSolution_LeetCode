package problemSet_1;

public class powxN {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if (n > 0) {
            return positivePower(x, n);
        }

        return negativePower(x, n);
    }

    private double positivePower(double x, int n) {
        if (n == 1) return x;
        double val = positivePower(x, n/2);
        if (n%2 == 0)
            return val*val;
        return x * val * val;
    }

    private double negativePower(double x, int n) {
        if (n == -1) return 1/x;
        double val = negativePower(x, n/2);
        if (n%2 == 0)
            return val*val;
        return val*val/x;
    }


/*                for (int j = k; j < width-k-1; j++)
            result.add(matrix[k][j]);
            for (int i = k; i < len-k-1; i++)
            result.add(matrix[i][width-k-1]);
            for (int j = width-k-1; j > k; j--)
            result.add(matrix[len-k-1][j]);
            for (i = len-k-1; i > k; i--)
            result.add(matrix[i][k]);*/
}
