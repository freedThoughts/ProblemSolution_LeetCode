package problemSet_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumGeneticMutation {

    public static void main(String[] arg) {
        System.out.println(minMutation("AACCGGTT", "AAACGGTA", new String[] {"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"}));
    }

    public static int minMutation(String start, String end, String[] bank) {

        Set<String> bankSet = new HashSet<>();
        for(String s: bank) bankSet.add(s);

        List<Integer> invalidIndexes = new ArrayList<Integer>();
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) invalidIndexes.add(i);
        }

        if (invalidIndexes.size() == 0) return 0;

        for (int i = 0; i < invalidIndexes.size(); i++) {
            if ( isValid(start, end, invalidIndexes, i, bankSet)) return invalidIndexes.size();
        }

        return -1;
    }

    static boolean isValid(String start, String end, List<Integer> invalidIndexes, int currentIndexInvalidList, Set<String> bankSet) {

        char[] startArr = start.toCharArray();
        startArr[invalidIndexes.get(currentIndexInvalidList)] = end.toCharArray()[invalidIndexes.get(currentIndexInvalidList)];
        String newString = new String(startArr);
        if (!bankSet.contains(newString)) return false;

        List<Integer> newInvalidIndexes = new ArrayList<>(invalidIndexes);
        newInvalidIndexes.remove(currentIndexInvalidList);

        if (newInvalidIndexes.size() == 0) return true;

        for (int i = 0; i < newInvalidIndexes.size(); i++) {
            if ( isValid(newString, end, newInvalidIndexes, i, bankSet)) return true;
        }

        return false;

    }
}
