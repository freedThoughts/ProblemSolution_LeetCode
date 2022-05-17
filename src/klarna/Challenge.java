package klarna;

public class Challenge {


    private static final String ST = "st";
    private static final String ND = "nd";
    private static final String RD = "rd";
    private static final String TH = "th";

    public static String numberToOrdinal( Integer number ) {

        String numberStr = number.toString();
        int len = numberStr.length();

        // Number as Zero
        if (number == 0){
            return numberStr;
        }

        // Teen number exception
        if (number > 9 && numberStr.charAt(len-2) == '1') {
            return numberStr + TH;
        }

        char lastChar = numberStr.charAt(len-1);
        switch(lastChar) {
            case '1': return numberStr + ST;
            case '2': return numberStr + ND;
            case '3': return numberStr + RD;
            default : return numberStr + TH;
        }
    }
}
