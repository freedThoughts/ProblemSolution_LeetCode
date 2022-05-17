package problemSet_1;

// https://leetcode.com/problems/reverse-words-in-a-string/submissions/
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        int i = 0, j = -1;
        for (; i < s.length();) {
            while(i < s.length() && s.charAt(i) == ' ') i++;
            if (i == s.length()) break;

            j = i;
            while(j < s.length() && s.charAt(j) != ' ') j++;

            StringBuffer newSb = new StringBuffer(s.substring(i,j));
            if (sb.length() != 0)
                newSb.append(new String(" "));
            sb = newSb.append(sb);
            i = j+1;
        }
        return new String(sb);
    }
}
