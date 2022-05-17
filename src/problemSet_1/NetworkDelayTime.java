package problemSet_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
// https://leetcode.com/problems/network-delay-time/
public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Set<Node>> map = new HashMap<>();
        for(int[] arr : times){
            Set<Node> set = map.get(arr[0]);
            if (set == null) set = new HashSet<>();
            set.add(new Node(arr[1], arr[2]));
            map.put(arr[0], set);
        }

        Map<Integer, Integer> timeTakenMap = new HashMap<>();
        timeTakenMap.put(k, 0);
        int maxTime = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        while(!queue.isEmpty()) {
            Integer element = queue.poll();
            Set<Node> nodes = map.get(element);
            if (nodes == null) continue;
            for(Node node : nodes) {
                //if (timeTakenMap.containsKey(node.dest)) continue;
                int time = node.time + timeTakenMap.get(element);

                Integer prevTime = timeTakenMap.get(node.dest);
                if (prevTime != null && prevTime <= time ) continue;
                timeTakenMap.put(node.dest, time);
                //maxTime = Math.max(maxTime, time);
                queue.add(node.dest);
            }
        }

        if (timeTakenMap.size() != n) return -1;
        for(Map.Entry<Integer, Integer> entry : timeTakenMap.entrySet()){
            maxTime = Math.max(maxTime, entry.getValue());
        }

        return maxTime;
    }

    class Node {
        int dest;
        int time;
        Node(){}
        Node (int dest, int time){
            this.dest = dest;
            this.time = time;
        }
    }
}
