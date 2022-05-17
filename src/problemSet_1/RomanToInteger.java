package problemSet_1;

import java.util.HashMap;
import java.util.Map;
// https://leetcode.com/problems/roman-to-integer/submissions/
public class RomanToInteger {

    public int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        int i = 0;
        while(i < s.length()) {
            if (i != s.length()-1 && map.get(s.charAt(i+1)) > map.get(s.charAt(i))) {
                sum = sum + map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                i = i +2;
                continue;
            }

            sum = sum + map.get(s.charAt(i));
            i++;
        }
        return sum;

    }



/*
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;

        for(int i = 0; i < s.length(); i++) {
            if (i != s.length()-1 && map.get(s.charAt(i+1)) > map.get(s.charAt(i)) ) {
                ans = ans + map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                i++;
                continue;
            }

            ans = ans + map.get(s.charAt(i));
        }

        return ans;

    }

    */
}
