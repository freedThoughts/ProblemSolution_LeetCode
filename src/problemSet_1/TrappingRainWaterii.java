package problemSet_1;
// https://leetcode.com/problems/trapping-rain-water-ii/submissions/
public class TrappingRainWaterii {

    public static void main(String[] arg) {
        int[][] heightMap = {{1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}};
        System.out.println(trapRainWater(heightMap));
    }

    public static int trapRainWater(int[][] heightMap) {

        int[][] minBoundary = new int[heightMap.length][heightMap[0].length];
        for(int i = 0; i < heightMap.length; i++) {
            int max = 0;
            for(int j = 0; j < heightMap[0].length; j++) {
                minBoundary[i][j] = Integer.MAX_VALUE;
                minBoundary[i][j] = Math.min(minBoundary[i][j], max);
                max = Math.max(max, heightMap[i][j]);
                System.out.print(minBoundary[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for(int i = 0; i < heightMap.length; i++) {
            int max = 0;
            for(int j = heightMap[0].length-1; j >= 0; j--) {
                //minBoundary[i][j] = Integer.MAX_VALUE;
                //System.out.println("minBoundary[i][j] " + minBoundary[i][j] + "max " + max);
                minBoundary[i][j] = Math.min(minBoundary[i][j], max);
                max = Math.max(max, heightMap[i][j]);
                System.out.print(minBoundary[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        //System.out.println(minBoundary);

        for(int j = 0; j < heightMap[0].length; j++ ) {
            int max = 0;
            for(int i = 0; i < heightMap.length; i++) {
                minBoundary[i][j] = Math.min(minBoundary[i][j], max);
                max = Math.max(max, heightMap[i][j]);
                System.out.print(minBoundary[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for(int j = 0; j < heightMap[0].length; j++ ) {
            int max = 0;
            for(int i = heightMap.length-1; i >= 0; i--) {
                minBoundary[i][j] = Math.min(minBoundary[i][j], max);
                max = Math.max(max, heightMap[i][j]);
                System.out.print(minBoundary[i][j] + " ");
            }
            System.out.println();
        }


        int sum = 0;
        for(int i = 0; i < heightMap.length; i++) {
            for(int j = 0; j < heightMap[0].length; j++) {
                if (heightMap[i][j] < minBoundary[i][j])
                    sum = sum + minBoundary[i][j] - heightMap[i][j];
            }
        }

        return sum;

    }
}
