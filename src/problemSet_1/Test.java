package problemSet_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Test {
    public static void main(String[] arg){

        List<Integer> results  = roundPricesToMatchTarget(Arrays.asList(0.7f, 2.8f, 4.9f), 8);
        System.out.println();

    }

    static float errorSum = 0;
    // Complete the roundPricesToMatchTarget function below.
    static List<Integer> roundPricesToMatchTarget(List<Float> prices, int target) {

        List<Integer> results = new ArrayList<>();
        errorSum = prices.size()+1;
        float currentError = (float) 0.0;
        backTrack(prices, target, results, errorSum, 0, currentError, new ArrayList<>());
        return results;
    }

    static void backTrack(List<Float> prices, int target, List<Integer> results, float errorSum, int i, float currentError, List<Integer> currentList){
        if (target < 0 || i == prices.size()) return;
        if (target == 0) {
            if (currentError < errorSum) {
                errorSum = currentError;
                for(int j = 0; j < currentList.size(); j++)
                    results.add(currentList.get(j));
            }
            return;
        }
        float rem = prices.get(i) % 1;
        int ceil =  (int)((1-rem) + prices.get(i));
        int floor = (int)(prices.get(i) - rem);

        currentList.add(ceil);

        backTrack(prices, target - ceil, results, errorSum, i+1, currentError+ 1-rem, currentList);
        currentList.remove(currentList.size()-1);

        currentList.add(floor);
        backTrack(prices, target - floor, results, errorSum, i+1, currentError+ rem, currentList);
        currentList.remove(currentList.size()-1);
    }
}
