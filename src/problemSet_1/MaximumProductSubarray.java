package problemSet_1;

public class MaximumProductSubarray {

    public static void main(String[] arg ) {
        //System.out.println(maxProduct(new int[] {0,-1,-4,4,-4,-5,-2,-1,-1,2,3,5,1,3,-6,-1,-1,0,0,-2}));
        System.out.println(maxProduct(new int[] {2, 3, 0, 9}));
    }

    public static int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        int product = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }

            max = Math.max(nums[i], nums[i] * max);
            min = Math.min(nums[i], nums[i]* min);
            product = Math.max(product, max);
        }
        return product;
    }


    public static long maxProduct3(int[] nums) {
        long[][] matrix = new long[nums.length][nums.length];
        long ans = Integer.MIN_VALUE;
        for(int k = 0; k < nums.length; k++) {
            for (int i = 0, j = k; j < nums.length; i++, j++) {
                if (i == j) {
                    matrix[i][j] = nums[i];
                } else {
                    matrix[i][j] = matrix[i][j-1] * matrix[i+1][j] / (matrix[i+1][j-1] != 0 ? matrix[i+1][j-1] : 1);
                }

                ans = ans < matrix[i][j] ? matrix[i][j] : ans;
            }
        }

        return ans;
    }

    public int maxProduct2(int[] nums) {
        int[] minArr = new int[nums.length];
        int[] maxArr = new int[nums.length];

        if (nums[0] == 0) {
            minArr[0] = 0;
            maxArr[0] = 0;
        } else {
            minArr[0] = nums[0];
            maxArr[0] = nums[0];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                minArr[i] = 1;
                maxArr[i] = 1;
            } else if (i == 0) {
                minArr[i] = nums[i];
                maxArr[i] = nums[i];
            } else {
                int val1 = nums[i] * minArr[i-1];
                int val2 = nums[i] * maxArr[i-1];
                if (val1 > val2) {
                    minArr[i] = val2;
                    maxArr[i] = val1;
                } else {
                    minArr[i] = val1;
                    maxArr[i] = val2;
                }
            }
        }

        return maxArr[nums.length-1];
    }
}
