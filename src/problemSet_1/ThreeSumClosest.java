package problemSet_1;

import java.util.Arrays;

// https://leetcode.com/problems/3sum-closest/
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int previousdiff = Integer.MAX_VALUE;
        int answer = 0;
        for(int i = 0; i < nums.length; i++) {
            int j = i+1, k = nums.length-1;
            while(j < k) {
                int val = nums[i] + nums[j] + nums[k];
                if (val == target) return target;
                int diff;
                if (val > target) {
                    diff = val - target;
                    k--;
                } else {
                    diff = target - val;
                    j++;
                }

                if (diff < previousdiff) {
                    previousdiff = diff;
                    answer = val;
                }
            }
        }
        return answer;
    }


    public static int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int output = 0;
        boolean foundAns = false;
        for(int i = 0; !foundAns && i< nums.length; i++) {
            for(int j = 0, k = nums.length-1; !foundAns && j < k;){
                if(i == j) {
                    j++;
                    continue;
                }
                if(i == k) {
                    k--;
                    continue;
                }
                int newDiff = nums[i] + nums[j] + nums[k] - target;
                newDiff = newDiff < 0 ? newDiff*-1 : newDiff;

                if ( newDiff < diff ) {
                    diff = newDiff;
                    output = nums[i] + nums[j] + nums[k];
                }
                if (nums[i] + nums[j] + nums[k] <  target) {
                    j++;
                } else if (nums[i] + nums[j] + nums[k] >  target) {
                    k--;
                } else {
                    foundAns = true;
                }
            }
        }
        return output;
    }

    public static void main(String[] arg) {
        System.out.println(threeSumClosest2(new int[] {-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33}, 0));
    }
}
