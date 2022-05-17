package airBnB;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] arg) {
        System.out.println(divide(-1, 3));
    }


    public static String divide(int dividend, int divisor) {
        int preDeceimal = dividend / divisor;
        boolean addNegative = false;
        if((dividend < 0 && divisor >= 0) || (divisor < 0 && dividend >= 0))
            addNegative = true;

        int decimalVal = dividend % divisor;
        if (decimalVal == 0) {
            return ((Integer)preDeceimal).toString();
        }
        //divisor = divisor < 0 ? divisor * -1: divisor;
        //decimalVal = decimalVal < 0 ? decimalVal * -1 : decimalVal;
        List<int[]> list = new ArrayList<>();
        while(decimalVal != 0){



            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)[0] == decimalVal) {
                    String s = ".";
                    for (int j = 0; j < i; j++) {
                        s = s.concat(((Integer)list.get(j)[1]).toString());
                    }
                    s = s.concat("(");
                    for (int j = i; j < list.size(); j++) {
                        s = s.concat(((Integer)list.get(j)[1]).toString());
                    }
                    s = s.concat(")");
                    s =  ((Integer)preDeceimal).toString().concat(s);
                    if (addNegative)
                        return "-".concat(s);
                    return s;
                }
            }
            int quotent = decimalVal * 10 / divisor;
            quotent = quotent < 0 ? quotent *-1 : quotent;
            list.add(new int[] {decimalVal, quotent});
            decimalVal = (decimalVal * 10) % divisor;
        }

        String s = ".";
        for (int j = 0; j < list.size(); j++) {
            s = s.concat(((Integer)list.get(j)[1]).toString());
        }
        s =  ((Integer)preDeceimal).toString().concat(s);
        if (addNegative)
            return "-".concat(s);
        return s;

    }
}
