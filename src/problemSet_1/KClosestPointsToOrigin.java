package problemSet_1;

import java.util.TreeSet;
// https://leetcode.com/problems/k-closest-points-to-origin/submissions/
public class KClosestPointsToOrigin {

    public static void main(String[] arg) {

        int[][] points = new int[][] { new int[]{0, 1}, new int[]{1, 0}};

        int[][] ans = kClosest(points, 2);
        System.out.print(ans);
    }

    public static int[][] kClosest(int[][] points, int k) {

        TreeSet<Node> treeSet = new TreeSet<>();
        for(int[] point : points) {
            Double dis = Math.sqrt( (point[0] * point[0]) + (point[1] * point[1]));
            if (treeSet.size() < k){
                treeSet.add(new Node(dis, point));
            } else if ( treeSet.last().dis > dis ) {
                treeSet.pollLast();
                treeSet.add(new Node(dis, point));
            }
        }

        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++) {
            Node node = treeSet.pollFirst();
            ans[i] = node.point;
        }

        return ans;
    }

    static class Node implements Comparable<Node>{
        Double dis;
        int[] point;

        Node(Double dis, int[] point) {
            this.dis = dis;
            this.point = point;
        }

        public int compareTo(Node node){
            int val =  this.dis.compareTo(node.dis);
            if (val == 0) return 1;
            return val;
        }
    }
}
