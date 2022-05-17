package problemSet_1;
// https://leetcode.com/problems/vowels-of-all-substrings/submissions/
public class VowelsOfAllSubstrings {

    public long countVowels(String word) {
        long sum = 0;

        for(int i = 0; i < word.length(); i++) {
            if ("aeiou".indexOf(word.charAt(i)) >= 0) {
                sum += (long)(i+1)*(word.length()-i);
            }
        }
        return sum;
    }
}
