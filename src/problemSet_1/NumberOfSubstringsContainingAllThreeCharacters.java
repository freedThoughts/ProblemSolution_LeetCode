package problemSet_1;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        if(s.length() < 3) return 0;
        int i = 0, j = 2;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        add(map, s.charAt(0));
        add(map, s.charAt(1));
        add(map, s.charAt(2));

        while(j < s.length() || i < s.length()-3) {

            while(j < s.length() && !contains(map)){
                j++;
                if (j == s.length()) return count;
                add(map, s.charAt(j));
            }

            count += s.length()-j;

            remove(map, s.charAt(i));
            i++;
            while(i < j && contains(map)) {
                count+=s.length()-j;
                remove(map, s.charAt(i));
                i++;
            }
        }
        return count;
    }

    void add(Map<Character, Integer> map, Character c) {
        Integer I = map.get(c);
        if (I == null) I = 1;
        else I+=1;
        map.put(c, I);
    }

    void remove(Map<Character, Integer> map, Character c) {
        Integer I = map.get(c);
        if(I == 1) map.remove(c);
        else map.put(c, --I);
    }

    boolean contains(Map<Character, Integer> map) {
        return map.containsKey('a') && map.containsKey('b') && map.containsKey('c');
    }
}
