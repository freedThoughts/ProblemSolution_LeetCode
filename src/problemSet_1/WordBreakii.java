package problemSet_1;
// https://leetcode.com/problems/word-break-ii/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakii {
    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> wordDictSet = new HashSet<>(wordDict);

        List<String> results = new ArrayList<>();
        backTracking(wordDictSet, results, s, new String(), 0, 0);
        return results;
    }

    void backTracking(Set<String> wordDictSet, List<String> results, String input, String currentString, int start, int current) {

        if (current >= input.length()) return;

        String str = input.substring(start, current+1);
        if (!wordDictSet.contains(str)) {
            backTracking(wordDictSet, results, input, currentString, start, current+1);
            return;
        }


        if (current == input.length()-1) {
            results.add(currentString.length() == 0 ? str : currentString + " " + str);
            return;
        }

        backTracking(wordDictSet, results, input, currentString, start, current+1);

        backTracking(wordDictSet, results, input, currentString.length() == 0 ? str : currentString + " " + str, current+1, current+1);

    }
}
