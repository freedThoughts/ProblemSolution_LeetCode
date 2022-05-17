package problemSet_1;

// https://leetcode.com/problems/zigzag-conversion/
public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        char[] result = new char[s.length()];
        int index = -1;
        for(int row = 0; row < numRows; row++) {
            int pointer = row;
            while(pointer < s.length()) {
                result[++index] = s.charAt(pointer);
                if(row != 0 && row != numRows-1) {
                    int newPointer = (2*(numRows-row) -2) + pointer;
                    if (newPointer < s.length()) {
                        result[++index] = s.charAt(newPointer);
                    }
                }
                pointer +=  2*numRows-2;
            }
        }

        return new String(result);
    }

    public static void main(String[] arg) {
        System.out.println(convert("0123456789ab", 3));
    }
}
