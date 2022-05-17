package problemSet_1;
// https://leetcode.com/problems/merge-sorted-array/submissions/
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] ans = new int[nums1.length];
        int i = 0, j = 0, k = 0;
        while(i < nums1.length - nums2.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                ans[k++] = nums1[i++];
                continue;
            }
            ans[k++] = nums2[j++];
        }

        while (i < nums1.length - nums2.length) {
            ans[k++] = nums1[i++];
        }

        while(j < nums2.length) {
            ans[k++] = nums2[j++];
        }

        for(i = 0; i < ans.length; i++)
            nums1[i] = ans[i];
    }
}

