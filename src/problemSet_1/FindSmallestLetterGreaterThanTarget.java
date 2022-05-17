package problemSet_1;
// https://leetcode.com/problems/find-smallest-letter-greater-than-target/submissions/
public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length-1;
        while(low <= high){

            if (low == high) {
                if (letters[low] > target) return letters[low];
                if (low == letters.length-1) return letters[0];
                while(low < letters.length-1 && letters[low+1] == letters[low])
                    low++;
                if (low == letters.length-1) return letters[0];
                return letters[low+1];
            }

            int mid = low + (high-low)/2;
            if(letters[mid] == target) {
                if (mid == letters.length-1) return letters[0];
                while(mid < letters.length-1 && letters[mid+1] == letters[mid])
                    mid++;
                if (mid == letters.length-1) return letters[0];
                return letters[mid+1];
            }

            if (letters[mid] < target) {
                low = mid+1;
            } else high = mid -1;
        }

        return letters[low];
    }
}
