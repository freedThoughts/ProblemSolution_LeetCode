package amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindValidDiscountCoupons {

    public static List<Integer> findValidDiscountCoupons(List<String> discounts) {

        Set<String> validStrings = new HashSet<>();
        validStrings.add("");
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < discounts.size(); i++) {
            String str = discounts.get(i);
            if (validStrings.contains(str)) results.add(1);
            else if(validate(str, 0, str.length()-1, validStrings)) {
                validStrings.add(str);
                results.add(1);
            } else results.add(0);
        }
        return results;
    }

    private static boolean validate(String str, int start, int end, Set<String> validStrings) {
        if (start >= end) return false;


        return false;

    }
}
