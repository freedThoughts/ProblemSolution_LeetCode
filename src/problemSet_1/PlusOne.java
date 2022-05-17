package problemSet_1;
// https://leetcode.com/problems/plus-one/submissions/
public class PlusOne {

    public int[] plusOne(int[] digits) {

        int[] result = new int[digits.length];
        int carry = 1;
        for(int i = digits.length-1; i >= 0; i--){
            int val = digits[i] + carry;
            carry = 0;
            if (val < 10) {
                result[i] = val;
                continue;
            }
            result[i] = val%10;
            carry = val/10;
        }

        if (carry == 0) return result;

        int[] ans = new int[digits.length+1];
        for(int i = digits.length-1; i >= 0; i-- ) {
            ans[i+1] = result[i];
        }

        ans[0] = carry;
        return ans;
    }
}
