package problemSet_1;

import java.util.Arrays;

public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
    public static void main(String[] arg) {
        System.out.println(maxArea(1000000000,
                1000000000,
                        new int[] {2},
                        new int[]{2}));
    }
    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        long maxArea = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        for(int i = 0; i <= horizontalCuts.length; i++) {
            int hVal = i == horizontalCuts.length ? h: horizontalCuts[i];
            for(int j = 0; j <= verticalCuts.length; j++) {
                int wVal = j == verticalCuts.length ? w : verticalCuts[j];

                long area = (hVal - (i == 0 ? 0 :horizontalCuts[i-1])) *
                        (wVal - (j == 0 ? 0 : verticalCuts[j-1]));
                if (area > maxArea) maxArea = area;

            }

        }

        return (int)(maxArea % 1000000007);

    }
}
