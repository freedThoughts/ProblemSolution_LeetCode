package amazon;

public class MinimumCoinFlips {

    public static void main(String[] args) {
        String s = "THHHTH";
        System.out.println(minimumCoinFlips(s, 0, s.length()-1));
    }

    public static int minimumCoinFlips(String coins, int start, int end){
        if (start >= end) return 0;
        if (end - start == 1) return 1;
        while (start < end && coins.charAt(start) == 'H') start++;
        while (start < end && coins.charAt(end) == 'T') end--;

        if (start <= end) return 0;
        if (end - start == 1) return 1;

        return 2 + minimumCoinFlips(coins, start+1, end-1);
    }
}
