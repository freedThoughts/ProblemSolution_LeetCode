package problemSet_1;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/palindrome-partitioning/submissions/
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        backTrack(results, new ArrayList<>(), s, 0);
        return results;
    }

    void backTrack(List<List<String>> results, List<String> currentList, String s, int index){
        if (index == s.length()) {
            results.add(new ArrayList(currentList));
            return;
        }

        for(int i = index; i < s.length(); i++) {
            String str = s.substring(index, i+1);
            if (isPanlindrom(str)) {
                currentList.add(str);
                backTrack(results, currentList, s, i+1);
                currentList.remove(currentList.size()-1);
            }
        }

    }

    boolean isPanlindrom(String str){
        for(int i = 0, j = str.length()-1; i < j; i++, j--)
            if (str.charAt(i) != str.charAt(j)) return false;
        return true;
    }
}
