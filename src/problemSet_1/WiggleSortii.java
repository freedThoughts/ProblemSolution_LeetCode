package problemSet_1;

import java.util.Arrays;

public class WiggleSortii {

    public static void main(String[] arg) {
        int[] nums = {1,5,1,1,6,4};
        wiggleSort(nums);
        Arrays.stream(nums).forEachOrdered(System.out::print);
        //System.out.println(nums);
    }

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int[] ans = new int[nums.length];

        int ansIndex = 0, i = 0;
        while(ansIndex < nums.length) {
            ans[ansIndex] = nums[i];
            ansIndex = ansIndex + 2;
            i++;
        }

        ansIndex = 1;
        while(ansIndex < nums.length) {
            ans[ansIndex] = nums[i];
            ansIndex = ansIndex + 2;
            i++;
        }


        //System.arraycopy();
        nums = ans;

    }
}
