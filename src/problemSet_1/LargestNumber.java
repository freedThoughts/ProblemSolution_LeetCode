package problemSet_1;

import java.util.Set;
import java.util.TreeSet;

public class LargestNumber {

    public static void main(String[] arg) {
        System.out.println(largestNumber(new int[]{34323,3432}));
    }

    public static String largestNumber(int[] nums) {
        if(isAllZero(nums)) return "0";
        Set<Integer> set = new TreeSet<>((a, b)-> -1*compare(a, b));
        for(int i : nums) set.add(i);
        StringBuffer sb = new StringBuffer();
        for(Integer I : set)
            sb.append(I.toString());
        return new String(sb);

    }

    static boolean  isAllZero(int[] nums){
        for(int i : nums)
            if(i != 0) return false;
        return true;
    }

    static int compare(Integer a, Integer b) {
        Long ab = Long.valueOf( a.toString().concat(b.toString()));
        Long ba = Long.valueOf(b.toString().concat(a.toString()));
        if(ab < ba) return -1;
        if(ba < ab) return 1;
        return 1;

    }

    static int compare(Integer a, Integer b, int i) {
        if (a.equals(b)) return 1;
        char[] aArr = a.toString().toCharArray();
        char[] bArr = b.toString().toCharArray();

        if (aArr.length <= i && i >= bArr.length) return 1;
        if (i < aArr.length && i < bArr.length) {
            if (aArr[i] < bArr[i]) return -1;
            if (aArr[i] > bArr[i]) return 1;
            return compare(a, b, i+1);
        }

        if (aArr.length == i){
            if (bArr[i] >= (i!= 0 ? bArr[i-1]: 0)) return 1;
            return -1;
        }
        if(bArr.length == i) {
            if (aArr[i] >= (i!=0 ? aArr[i-1]: 0)) return 1;
            return -1;
        }
        return -1;

    }
}
