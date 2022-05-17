package hero;

public class LongestConsecutiveNumbers {

    public static void main(String[] arg) {
        //int[] A = new int[] {1, 2, 3 ,5, 6, 7, 8, 9};
        int[] A = new int[] {5, -3, -2, -1, 0, 1, 5, 6, 7};
        System.out.print(solution(A));
    }

    public static int solution(int[] A) {
        if (A.length == 0) return 0;
        int ans = 1;
        int start = 0;
        int i = 1;
        for(; i< A.length; i++) {
            if (A[i] == A[i-1]+1 || A[i] == A[i-1]-1)
                continue;
            ans = Math.max(ans, i-start);
            start = i;
        }
        return Math.max(ans, i-start);
    }
}
