package problemSet_1;
// https://leetcode.com/problems/happy-number/submissions/

import java.util.HashMap;

public class happyNumber {
    public boolean isHappy(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        while(n != 1) {
            if (map.containsKey(n)) return false;
            int number = n;
            int sum = 0;
            while(number != 0) {
                int lastDigit = number %10;
                sum = sum + lastDigit * lastDigit;
                number = number /10;
            }
            if (sum == 1) return true;
            map.put(n, sum);
            n = sum;
        }
        return true;
    }
}
