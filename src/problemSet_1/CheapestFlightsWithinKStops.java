package problemSet_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
// https://leetcode.com/problems/cheapest-flights-within-k-stops/
public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] wtArr = new int[n];
        for(int i = 0; i < n; i++)
            wtArr[i] = Integer.MAX_VALUE;


        Map<Integer, Set<Node>> edges = new HashMap<>();
        for(int[] arr : flights){
            Set<Node> set = edges.get(arr[0]);
            if (set == null) set = new HashSet<>();
            set.add(new Node(arr[0], arr[1], arr[2]));
            edges.put(arr[0], set);
        }

        wtArr[src] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        queue.add(null);
        int hub = 0;
        Map<Integer, Integer> currentMap = new HashMap<>();

        while(hub <= k && !queue.isEmpty()) {

            Integer currentNode = queue.remove();

            System.out.println(currentNode);
            if (currentNode == null) {
                hub++;

                for(Map.Entry<Integer, Integer> entry : currentMap.entrySet()) {
                    if (entry.getValue() < wtArr[entry.getKey()]) {
                        wtArr[entry.getKey()] = entry.getValue();
                        queue.add(entry.getKey());
                    }
                }

                currentMap = new HashMap<>();

                if(!queue.isEmpty())
                    queue.add(null);
                continue;
            }

            Set<Node> nodes = edges.get(currentNode);
            if (nodes == null) continue;


            for(Node node : nodes) {
                System.out.println("Node: " + node.dest);
                int calWt = wtArr[currentNode] + node.wt;
                if (calWt < wtArr[node.dest] && (!currentMap.containsKey(node.dest) || calWt < currentMap.get(node.dest))) {
                    currentMap.put(node.dest, calWt);
                    //wtArr[node.dest] = calWt;
                    //queue.add(node.dest);
                }
            }


        }

        if (wtArr[dst] == Integer.MAX_VALUE) return -1;
        return wtArr[dst];

    }

    class Node {
        int src;
        int dest;
        int wt;

        Node(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
}
