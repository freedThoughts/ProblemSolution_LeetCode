package arcesium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {
    public static void main(String[] arg) {
/*
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(3);
        list.add(3);

        Arrays.asList(3, 4, 5);
        Arrays.asList(1, 2 ,3, 7);*/


        // O(m+n) --- time

        System.out.println(merge(Arrays.asList(Arrays.asList(3, 4, 5), Arrays.asList(1, 2 ,3, 7), Arrays.asList(2, 4 ,6, 8))));
        //System.out.println("efveverfr");
    }

    static List<Integer> merge(List<List<Integer>> list) {
        List<List<Integer>> resultList = new ArrayList<>();
        int i = 0;
        for(; i < list.size()-1; i++) {
            List<Integer> list1 = list.get(i);
            i++;
            List<Integer> list2 = list.get(i);
            List<Integer> ansList = merge(list1, list2);
            resultList.add(ansList);
        }
        if (i < list.size())
            resultList.add(list.get(i));

        if (resultList.size() == 1) return resultList.get(0);
        return merge(resultList);
    }

    // size = m
    // count = n
    // 2m * n/2  ==> size a, cont b
    // 2a * b/2 ==>
    //

    // list1 ==> 2+3+5+10+20 +40 * (n-1)
    // CAP -->
    // avail lack in RDBMS
    // ACID -->



    // key based , hash based
    // hash based
    // kubectl, helm
    // helm
    // - replicas -- 10
    // k8 --
    // traffic -- rps
    // cpu + memory
    // pass aws
    //

    static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        if (list1.isEmpty()) return list2;
        if (list2.isEmpty()) return list1;

        List<Integer> resultList = new ArrayList<>(list1.size()+ list2.size());
        int i = 0, j = 0;
        while(i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                resultList.add(list1.get(i));
                i++;
                continue;
            }

            resultList.add(list2.get(j));
            j++;
        }

        while(i < list1.size()) {
            resultList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            resultList.add(list2.get(j));
            j++;
        }

        return resultList;
    }
}
