package problemSet_1;
// https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int midIndex = (nums1.length + nums2.length)/2;
        if (len % 2 == 0) midIndex--;
        int i = 0, j = 0, k = 0;
        int prev = -1;
        while(k <= midIndex) {
            if (i == nums1.length) {
                prev = nums2[j];
                j++;
                k++;

            } else if (j == nums2.length) {
                prev = nums1[i];
                i++;
                k++;

            } else {
                if (nums1[i] < nums2[j]) {
                    prev = nums1[i];
                    i++;
                    k++;

                } else {
                    prev = nums2[j];
                    j++;
                    k++;

                }
            }
        }

        if (len % 2 == 1) return prev;
        int nextElem = (i == nums1.length || (j != nums2.length && nums1[i] > nums2[j])) ? nums2[j] : nums1[i];
        return ((double) nextElem + prev)/2;

    }
}
