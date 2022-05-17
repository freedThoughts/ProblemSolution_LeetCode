package problemSet_1;


import java.util.HashMap;
// https://leetcode.com/problems/making-file-names-unique/

public class MakingFileNamesUnique {
    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] results = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            if(!map.containsKey(names[i])) {
                map.put(names[i], 1);
                results[i] = names[i];
            } else {
                Integer count = map.get(names[i]);
                String newStr = names[i] + "(" + count + ")";
                while(map.containsKey(newStr)) {
                    newStr = names[i] + "(" + ++count + ")";
                }
                map.put(newStr, 1);
                map.put(names[i], count+1);
                results[i] = newStr;
            }
        }

        return results;
    }
}
