package problemSet_1;
// https://leetcode.com/problems/candy/
public class Candy {

    public int candy3(int[] ratings) {
        int[] lrArr = new int[ratings.length];
        for(int i = 1; i < ratings.length; i++ ) {
            if (ratings[i] > ratings[i-1]) {
                lrArr[i] = lrArr[i-1]+1;
            }
        }

        int ans = lrArr[lrArr.length-1] +1;
        int prevCandy = 1;
        for (int i = ratings.length-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                prevCandy = 1 + prevCandy;
            } else {
                prevCandy = 1;
            }
            ans = ans + Math.max(lrArr[i]+1, prevCandy);
        }

        return ans;
    }

    // Accepted
    public int candy2(int[] ratings) {

        int[] candyArr = new int[ratings.length];
        int remCount = ratings.length;
        int ans = 0;
        int currentCandy = 1;
        while(remCount > 0) {
            for(int i = 0; i < ratings.length; i++) {
                if (candyArr[i] > 0) continue;
                if (i != 0 && (candyArr[i-1] == 0 || candyArr[i-1] == currentCandy) &&
                        ratings[i-1] < ratings[i])
                    continue;
                if (i != ratings.length-1 && candyArr[i+1] == 0 && ratings[i+1] < ratings[i])
                    continue;

                candyArr[i] = currentCandy;
                ans = ans + currentCandy;
                remCount--;
            }
            currentCandy++;
        }
        return ans;
    }

    public int candy(int[] ratings) {

        int ans = 0;
        Integer[] arr = new Integer[ratings.length];

        int changes = 0;
        int currentCandyVal = 1;
        while(changes < arr.length) {

            for(int i = 0; i < arr.length; i++) {
                if (    arr[i] != null ||
                        (i != 0 && arr[i-1] == null && ratings[i-1] < ratings[i]) ||
                        (i != arr.length-1 && arr[i+1] == null && ratings[i+1] < ratings[i])
                ) continue;

                arr[i] = currentCandyVal;
                ans = ans + arr[i];
                changes++;
            }
            currentCandyVal++;
        }

        return ans;

    }
}
