package Seera;

import java.util.HashMap;
import java.util.Map;

public class Test1 {


    public static String SearchingChallenge(String str) {
        // code goes here
        String result = "";
        Map<Character, Integer> map = new HashMap<>();
        int k = str.charAt(0) - 48;

        int start = 1, end = 1;
        while(end < str.length()) {
            char ch = str.charAt(end);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) +1);
                end++;
            } else if(map.size() < k){
                map.put(ch, 1);
                end++;
            } else {
                String ans = str.substring(start, end);
                if (ans.length() > result.length()) result = ans;
                while(map.size() == k) {
                    Integer val = map.get(str.charAt(start));
                    if (val == 1) {
                        map.remove(str.charAt(start));
                    } else {
                        map.put(str.charAt(start), val-1);
                    }
                    start++;
                }
            }

        }

        String ans = str.substring(start, end);
        if (ans.length() > result.length()) result = ans;

        return result;


    }
}
