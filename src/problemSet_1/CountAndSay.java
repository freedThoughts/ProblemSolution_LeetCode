package problemSet_1;

// https://leetcode.com/problems/count-and-say/
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String previousString = countAndSay(n-1);
        String s = "";
        for (int i = 0; i < previousString.length(); ) {
            int j = i;
            while(j < previousString.length() && previousString.charAt(i) == previousString.charAt(j)) {
                j++;
            }

            s = s + (""+(j-i)) + (""+previousString.charAt(i));
            i = j;
        }
        return s;
    }
}
