package Striim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test222 {

    public static void main(String[] arg) {
    List<String> results = evaluateActions(Arrays.asList(
        "A Munich Hold",
            "B Bohemia Move Munich",
            "C Warsaw Support B"

    ));

    System.out.println();
    }

    static List<String> evaluateActions(List<String> actions) {
        Map<String, List<String>> placeNameMap = new HashMap<>();
        for(String act : actions){
            String[] str = act.split(" ");
            String dest = str[2].equals("Move")  ? str[3] : str[1];
            List<String> names = placeNameMap.get(dest);
            if (names == null) names = new ArrayList<>();
            names.add(str[0]);
            placeNameMap.put(dest, names);
        }

        Map<String, Integer> namePointMap = new HashMap<>();
        for(String act : actions){
            String[] str = act.split(" ");
            if (!str[2].equals("Support")) continue;
            if(placeNameMap.get(str[1]).size() > 1) continue;
            Integer point = namePointMap.get(str[3]);
            if (point == null) point = 1;
            else point = point+1;
            namePointMap.put(str[3], point);
        }

        Map<String, List<String>> destWinnersMap = new HashMap<>();
        for(Map.Entry<String, List<String>> entry : placeNameMap.entrySet()){
            List<String> maxPointHolder = maxPointName(entry.getValue(), namePointMap);
            destWinnersMap.put(entry.getKey(), maxPointHolder);
        }

        List<String> results = new ArrayList<>();
        for(String act : actions){
            String[] str = act.split(" ");
            String dest = str[2].equals("Move")  ? str[3] : str[1];
            List<String> maxPointHolder = destWinnersMap.get(dest);
            if (maxPointHolder.size() == 1 && str[0].equals(maxPointHolder.get(0))) {
                results.add(str[0] + " " + dest);
                continue;
            }

            results.add(str[0] + " " + "[dead]");
        }

        return results;


    }

    static List<String> maxPointName(List<String> names, Map<String, Integer> namePointMap) {

        int maxPoint = 0;
        List<String> maxPointHolders = null;
        for (String name : names){
            Integer point  = namePointMap.get(name);
            if (point == null) point = 1;

            if (point > maxPoint) {
                maxPoint = point;
                maxPointHolders = new ArrayList<>();
                maxPointHolders.add(name);
                continue;
            }
            if (point == maxPoint) maxPointHolders.add(name);
        }

        return maxPointHolders;
    }
}
