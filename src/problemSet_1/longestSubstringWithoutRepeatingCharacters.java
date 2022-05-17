package problemSet_1;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class longestSubstringWithoutRepeatingCharacters {
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
