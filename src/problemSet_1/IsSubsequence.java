package problemSet_1;
// https://leetcode.com/problems/is-subsequence/submissions/
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int patIndex = 0; int sIndex = 0;
        while(patIndex < t.length() && sIndex < s.length()) {
            while(patIndex < t.length() && s.charAt(sIndex) != t.charAt(patIndex)) {
                patIndex++;
            }

            if (patIndex < t.length()) {
                sIndex++;
                patIndex++;
            }

        }

        return sIndex == s.length();
    }
}
