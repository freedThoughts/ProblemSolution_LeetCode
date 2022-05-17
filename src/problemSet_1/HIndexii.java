package problemSet_1;
// https://leetcode.com/problems/h-index-ii/
public class HIndexii {
    public int hIndex(int[] citations) {
        for(int i = citations.length-1; i>= 0; i--) {
            if(citations[i] >= citations.length-i && (i == 0 || citations[i-1] <= citations.length-i)) return citations.length-i;
        }
        return 0;
    }
}
