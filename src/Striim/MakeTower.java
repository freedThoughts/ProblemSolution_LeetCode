package Striim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MakeTower {

    public static void main(String[] arg) {

        ArrayList<Integer>[] arrayLists = makeTower2(new int[] {2, 1, 3, 6, 4, 5, 0});
        System.out.println();

/*        TreeSet<Integer> previousSet = new TreeSet<>();
        previousSet.add(4);
        previousSet.add(5);
        previousSet.add(1);
        previousSet.add(2);
        previousSet.add(3);

        previousSet.first();
        previousSet.pollFirst();
        previousSet.first();

        System.out.println();*/
    }

    static ArrayList<Integer>[] makeTower2(int[] arr) {

        ArrayList<Integer>[] results = new ArrayList[arr.length];
        int resultIndex = 0;
        TreeSet<Integer> sortedSet = new TreeSet<>(Comparator.reverseOrder());
        for (int i : arr) sortedSet.add(i);

        TreeSet<Integer> previousSet = new TreeSet<>(Comparator.reverseOrder());

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < sortedSet.first()) {
                previousSet.add(arr[i]);
                results[resultIndex++] = new ArrayList<>();
                continue;
            }
            ArrayList<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            sortedSet.pollFirst();
            while (!previousSet.isEmpty() && previousSet.first() > sortedSet.first()) {
                list.add(previousSet.pollFirst());
            }
            results[resultIndex++] = list;
        }

        return results;
    }

    static ArrayList<Integer>[] makeTower(int[] arr) {
        ArrayList<Integer>[] results = new ArrayList[arr.length];
        List<Integer> sortedList = new ArrayList<>();
        for(int i : arr)
            sortedList.add(i);
        sortedList.sort(Comparator.reverseOrder());
        int sortedIndex = 0;

        TreeSet<Integer> previousSet = new TreeSet<>(Comparator.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < sortedList.get(sortedIndex)) {
                previousSet.add(arr[i]);
                results[i] = new ArrayList<>();
                continue;
            }

            ArrayList<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            sortedIndex++;
            while (!previousSet.isEmpty() && previousSet.first().equals(sortedList.get(sortedIndex))) {
                list.add(previousSet.pollFirst());
                sortedIndex++;
            }
            results[i] = list;
        }
        return results;
    }


}
