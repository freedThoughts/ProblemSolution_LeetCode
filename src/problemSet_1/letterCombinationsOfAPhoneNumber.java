package problemSet_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class letterCombinationsOfAPhoneNumber {
    Map<Character, List<String>> map = new HashMap();
    public List<String> letterCombinations(String digits) {


        List<String> ls = new ArrayList();
        ls.add("a");
        ls.add("b");
        ls.add("c");
        map.put('2', ls);

        ls = new ArrayList();
        ls.add("d");
        ls.add("e");
        ls.add("f");
        map.put('3', ls);

        ls = new ArrayList();
        ls.add("g");
        ls.add("h");
        ls.add("i");
        map.put('4', ls);

        ls = new ArrayList();
        ls.add("j");
        ls.add("k");
        ls.add("l");
        map.put('5', ls);

        ls = new ArrayList();
        ls.add("m");
        ls.add("n");
        ls.add("o");
        map.put('6', ls);

        ls = new ArrayList();
        ls.add("p");
        ls.add("q");
        ls.add("r");
        ls.add("s");
        map.put('7', ls);

        ls = new ArrayList();
        ls.add("t");
        ls.add("u");
        ls.add("v");
        map.put('8', ls);

        ls = new ArrayList();
        ls.add("w");
        ls.add("x");
        ls.add("y");
        ls.add("z");
        map.put('9', ls);


        List<String> result = new ArrayList<String>();
        if (digits.length() == 0)
            return result;
        result.add("");
        for(int i = 0; i < digits.length(); i++) {
            result = getResults(result, digits.charAt(i));
        }
        return result;
    }

    List<String> getResults(List<String> result, char c) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < result.size(); i++ ) {
            List<String> s = map.get(c);
            for (int j = 0; j < s.size(); j++) {
                list.add(result.get(i) + s.get(j));
            }
        }
        return list;
    }
}
