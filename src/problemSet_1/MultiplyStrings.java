package problemSet_1;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {
    public static void main(String[] arg) {
        System.out.println(multiply("456", "123"));
    }

    public static String multiply(String num1, String num2) {
        List<int[]> results = new ArrayList<>();
        int carry = 0;

        for (int j = num2.length()-1; j >= 0; j--) {
            int[] ans = new int[num1.length()+ num2.length() - j];
            int ansIndex = num2.length() - j -1;
            for (int i = num1.length()-1; i>= 0; i--, ansIndex++) {
                int val = (num2.charAt(j) -48) * (num1.charAt(i) - 48) + carry;
                ans[ansIndex] = val % 10;
                carry = val /10;
            }
            ans[ansIndex] = carry;
            carry = 0;
            results.add(ans);
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < results.get(results.size()-1).length; i++) {
            int val = 0;
            for (int j = 0; j < results.size(); j++) {
                val = val + getValue(results.get(j), i);
            }
            val = val + carry;

            carry = val /10;
            StringBuffer sb2 = new StringBuffer();

            sb2.append(val %10);
            sb = sb2.append(sb);
        }

        int i = 0;
        for (; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') break;
        }

        return new String(sb.substring(i, sb.length()));
    }

    static int getValue(int[] arr, int index) {
        if (index >= arr.length || index < 0) return 0;
        return arr[index];
    }
}
