package problemSet_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            List<String> ls = map.get(sortedString);
            if (ls == null)
                ls = new ArrayList<String>();

            ls.add(str);
            map.put(sortedString, ls);
        }

        return new ArrayList<>(map.values());

    }
}
