package outfittery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/*

Horizontal level

        1   -----------------vertcal level
      /.     \
    2.       3
  /.  \      /.  \
4.    5.    6.    7
/ \    /
8  10 9
\
 x
  \
  y


8,4,9,5,6,3,7

horiLev --> -1 --> (2)
-1        (10, 9)

 */
public class Test3 {
    public static void main(String[] arg) {
        System.out.println("dscdvfsvsfvs");

    }


    void bottomLook(Node root) {
        if (root == null) return;

        Map<Integer, Answer> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        root.horizontalLevel = 0;
        queue.add(root);
        queue.add(null);
        int level = 0;
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node == null) {
                level++;
                if (!queue.isEmpty()) queue.add(null);
                continue;
            }

            Answer ans = map.get(node.horizontalLevel);

            if (ans == null || ans.level != level) {
                ans = new Answer();
                ans.level = level;
                ans.nodes.add(node);
            } else
                ans.nodes.add(node);

            map.put(node.horizontalLevel, ans);
            if (node.left != null) {
                node.left.horizontalLevel = node.horizontalLevel -1;
                queue.add(node.left);
            }
            if (node.right != null) {
                node.right.horizontalLevel = 1 + node.horizontalLevel;
                queue.add(node.right);
            }
        }

        Map<Integer, Answer> treeMap = new TreeMap<>(map);
        for(Map.Entry<Integer, Answer> entry : treeMap.entrySet()) {
            List<Node> list = entry.getValue().nodes;
            for(Node node : list)
                System.out.print(node.val + " ");
        }
            //System.out.print(entry.getValue() + " ");

    }

    class Answer {

        int level;
        List<Node> nodes;

        Answer(){
            this.nodes = new ArrayList<>();
        }
    }
/*
    void bottomLook(Node root) {
        if (root == null) return;

        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        root.horizontalLevel = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            map.put(node.horizontalLevel, node);
            if (node.left != null) {
                node.left.horizontalLevel = node.horizontalLevel-1;
                queue.add(node.left);
            }
            if (node.right != null) {
                node.right.horizontalLevel = 1 + node.horizontalLevel;
                queue.add(node.right);
            }
        }

        Map<Integer, Node> treeMap = new TreeMap<>(map);
        for(Map.Entry<Integer, Node> entry : treeMap.entrySet())
            System.out.print(entry.getValue() + " ");

    }*/


    class Node {
        Node left;
        Node right;
        int val;
        int horizontalLevel;
    }
}
