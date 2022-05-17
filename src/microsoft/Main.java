package microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String input = "0XFF";
        if (input.startsWith("0X"))
            System.out.println(printHex(input.substring(2)));
        else if (input.length() >= 3 && input.charAt(0) == '-' && input.substring(1, 3).equals("0X"))
            System.out.println(-1*printHex(input.substring(3)));
        else System.out.println(print(input));
    }

    static Integer print(String str) {
        // 0XFF
        // 255
        // base 16
        // F -- > 15
        // FF -> 15 * 16^1 + 15

        // 234
        // 4 * 10 ^ (3-2-1 = 0) = 4 * 10^0 = 4
        // 4 + 3 * 10^(3-1-1 = 1) = 4 + 3 * 10^1 =  34
        // 34 + 2 * 10 ^ (3 - 0 -1 = 2) = 34 + 2*10^2 = 234

        double ans = 0;
        char[] chars = str.toCharArray();
        for(int i = chars.length-1; i >= 0; i--) {
            if (i == 0 && chars[i] == '-') continue;
            if(!isValidChar(chars[i])) throw new RuntimeException("String not valid");

            ans = ans + (chars[i]-48) * Math.pow(10.0, (double) chars.length-i-1);
        }

        return chars[0] == '-' ? -1*(int) ans : (int) ans;
    }

    static Integer printHex(String str) {
        double ans = 0;
        char[] chars = str.toCharArray();
        for(int i = chars.length-1; i >= 0; i--) {
            //if (i == 0 && chars[i] == '-') continue;
            if(!isValidCharHex(chars[i])) throw new RuntimeException("String not valid");

            ans = ans + getValue(chars[i]) * Math.pow(16.0, (double) chars.length-i-1);

        }

        return (int) ans;
    }

    static int getValue(char ch) {
        if (isValidChar(ch)) return ch - 48;
        if (isValidCharHex(ch)) return ch-64+9;
        return 0;
    }

    static boolean isValidCharHex(char ch) {
        if (ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9' || ch == 'A' || ch == 'B' || ch == 'C' || ch == 'D' || ch == 'E' || ch == 'F' )
            return true;
        return false;
    }

    static boolean isValidChar(char ch) {
        if (ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9')
            return true;
        return false;
    }




}
