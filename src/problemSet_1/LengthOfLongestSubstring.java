package problemSet_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] arg) {
        System.out.println(lengthOfLongestSubstring2("au"));
    }


    public static int lengthOfLongestSubstring2(String s) {
        int i = 0, j = 0;
        String ans = "";
        Set<Character> set = new HashSet<Character>();
        while(j < s.length()-1) {
            while(j < s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            }

            String a = s.substring(i, j);
            if (a.length() > ans.length()) {
                ans = a;
            }

            if (j == s.length()) {
                return ans.length();
            }

            while(s.charAt(i) != s.charAt(j)) {
                set.remove(s.charAt(i));
                i++;
            }
            set.remove(s.charAt(i));
            i++;
        }

        return ans.length();
    }

    public int lengthOfLongestSubstring(String s) {

        int output = 0;
        int i = 0, j = 0;
        Set<Character> set = new HashSet();
        while(j < s.length()){
            while(j < s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            }
            output = Math.max(output, set.size());

            while(j < s.length() && set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return output;
    }
}
