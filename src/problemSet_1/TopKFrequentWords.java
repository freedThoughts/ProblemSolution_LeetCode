package problemSet_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
// https://leetcode.com/problems/top-k-frequent-words/submissions/
public class TopKFrequentWords {

    // O(k log n)
    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        // O(n)
        for(String str : words) {
            Integer val = map.get(str);
            if (val == null) map.put(str, 1);
            else map.put(str, val+1);
        }

        TreeSet<Node> treeSet = new TreeSet<>((a, b) -> {
            int val = b.freq.compareTo(a.freq);
            if (val == 0) return a.word.compareTo(b.word);
            return val;
        });

        // O(n)
        List<Node> list = map.entrySet().stream()
                .map( entry -> new Node(entry.getValue(), entry.getKey()))
                .collect(Collectors.toList());

        // O(n)
        treeSet.addAll(list);
/*

        // O(n)
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            Node node = new Node(entry.getValue(), entry.getKey());
            // O(log n)
            treeSet.add(node);
        }
*/

        List<String> ans = new ArrayList<>();
        // O(k)
        while(ans.size() < k)
            // O(log n)
            ans.add(treeSet.pollFirst().word);

        return ans;
    }

    // O(n log k)
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        // O(n)
        for(String str : words) {
            Integer val = map.get(str);
            if (val == null) map.put(str, 1);
            else map.put(str, val+1);
        }

        TreeSet<Node> treeSet = new TreeSet<>((a, b) -> {
            int val = a.freq.compareTo(b.freq);
            if (val == 0) return b.word.compareTo(a.word);
            return val;
        });

        // O(n)
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            Node node = new Node(entry.getValue(), entry.getKey());

            // O(k)
            if (treeSet.size() < k) treeSet.add(node);
            else if (treeSet.first().freq < node.freq || (treeSet.first().freq == node.freq && treeSet.first().word.compareTo(node.word) > 0) ){
                treeSet.pollFirst();
                treeSet.add(node);
            }
        }

        List<String> ans = new ArrayList<>();
        // O(k)
        while(treeSet.size() > 0)
            // O(log k)
            ans.add(treeSet.pollLast().word);

        return ans;
    }

    class Node {
        Integer freq;
        String word;

        Node (Integer freq, String str) {
            this.freq = freq;
            this.word = str;
        }
    }

}
