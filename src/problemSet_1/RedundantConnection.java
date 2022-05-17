package problemSet_1;

import java.util.HashMap;
import java.util.Map;

public class RedundantConnection {

    public static void main(String[] arg) {
        int[][] edges = {{4,5},{1,2},{2,4},{3,4},{2,3}};
        int[] ans = findRedundantConnection(edges);
        System.out.print(ans[0] + " " + ans[1]);
    }

    public static int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Node> map = new HashMap<>();
        int len = edges.length;
        for(int i = 1; i <= len; i++) {
            map.put(i, new Node(i));
        }

        for(int[] edge : edges) {
            if(getParent(edge[0], map).id == getParent(edge[1], map).id) return edge;
            union(edge[0], edge[1], map);
        }

        return new int[]{};

    }

    static Node getParent(Integer a, Map<Integer, Node> map) {
        Node node = map.get(a);
        if (node.parent.id != node.id) {
            node.parent = getParent(node.parent.id, map);
        }
        return node.parent;
    }

    static void union(int a, int b, Map<Integer, Node> map) {
        Node node1 = map.get(a);
        Node node2 = map.get(b);

        Node node1Parr = getParent(a, map);
        Node node2Parr = getParent(b, map);

        if (node1Parr.rank == node2Parr.rank) {
            node1Parr.rank++;
            node2Parr.parent = node1Parr;
            //node1.parent = node1Parr;
            //node2.parent = node1Parr;
        } else if (node1Parr.rank > node2Parr.rank) {
            node2Parr.parent = node1Parr;
            //node1.parent = node1Parr;
            //node2.parent = node1Parr;
        } else
            node1Parr.parent = node2Parr;
        //node1.parent = node2Parr;
        //node2.parent = node2Parr;

    }

    static class Node {
        int id;
        int rank;
        Node parent;

        Node(int id){
            this.id = id;
            this.rank = 0;
            this.parent = this;
        }
    }
}
