package problemSet_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/repeated-dna-sequences/submissions/
public class RepeatedDnaSequences {

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < s.length()-9; i++) {
            String str = s.substring(i, i+10);
            Integer I = map.get(str);
            if(I == null) {
                map.put(str, 1);
                continue;
            }
            map.put(str, I+1);
            if(I == 1) ans.add(str);
        }
        return ans;
    }
}
