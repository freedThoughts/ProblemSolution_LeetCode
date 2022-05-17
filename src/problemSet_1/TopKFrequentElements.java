package problemSet_1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

// https://leetcode.com/problems/top-k-frequent-elements/submissions/
public class TopKFrequentElements {



    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Node> map = new HashMap<>();
        for(Integer i : nums) {
            Node val = map.get(i);
            if (val == null) val = new Node(i, 0);
            val.freq =  val.freq + 1;

            map.put(i, val);
        }


        TreeSet<Node> treeSet = new TreeSet<>(map.values());
        int[] ans = new int[k];
        int i = 0;
        while(!treeSet.isEmpty() && i < k) {
            ans[i++] = treeSet.pollFirst().key;
        }
        return ans;
    }

    class Node implements Comparable<Node>{
        Integer key;
        Integer freq;

        Node(Integer key, Integer freq) {
            this.key = key;
            this.freq = freq;
        }

        public int compareTo(Node that) {
            int val =  that.freq.compareTo(this.freq);
            if (val == 0) return 1;
            return val;
        }
    }




/*

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            Integer count = map.get(i);
            if (count == null) map.put(i, 1);
            else map.put(i, count+1);
        }
        TreeSet<Node> set = new TreeSet<Node>((n, m) -> {
            int i = n.count.compareTo(m.count);
            if (i == 0) return -1;
            return i;
        });

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (set.size() < k) set.add(new Node(entry.getKey(), entry.getValue()));
            else if (set.first().count < entry.getValue()) {
                set.pollFirst();
                set.add(new Node(entry.getKey(), entry.getValue()));
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++)
            ans[i] = set.pollFirst().num;

        return ans;
    }

    class Node {
        Integer num;
        Integer count;
        Node(Integer num, Integer count) {
            this.num = num;
            this.count = count;
        }
    }

    */
}
