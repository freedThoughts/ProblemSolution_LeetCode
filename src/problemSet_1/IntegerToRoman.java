package problemSet_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

//https://leetcode.com/problems/integer-to-roman/
public class IntegerToRoman {

    public static String intToRoman(int num) {
        int[] value = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuffer buffer = new StringBuffer();

        for(int i = (""+num).length()-1; i >= 0; i--) {
            int temp = (int) Math.pow(10.0, i);
            int val = (num / temp) * temp;
            num = num - val;

            for(int j = 0; j < symbol.length && val != 0; ) {
                if (val < value[j]) {
                    j++;
                    continue;
                }
                buffer.append(new StringBuffer(symbol[j]));
                val = val - value[j];
            }
        }
        return new String(buffer);
    }

    public static void main(String[] arg) {
        System.out.println(intToRoman(58));

    }


}
