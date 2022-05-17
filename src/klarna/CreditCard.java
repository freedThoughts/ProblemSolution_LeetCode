package klarna;

public class CreditCard {

    private static final char maskChar = '#';

    public static String maskify(String creditCardNumber) {

        int len = creditCardNumber.length();

        // creditCardNumber is less than 6 characters.
        if (len < 6) {
            return creditCardNumber;
        }

        char[] maskedCharArr = new char[len];
        for(int i = 0; i < len; i++) {
            char ch = creditCardNumber.charAt(i);
            if (ch < 48 || ch > 57 || i == 0 || i >= len-4) {
                maskedCharArr[i] = ch;
                continue;
            }

            // Masking
            maskedCharArr[i] = maskChar;
        }

        return new String(maskedCharArr);
    }
}
