package problemSet_1;

import java.util.HashMap;
import java.util.Map;
// https://leetcode.com/problems/implement-trie-prefix-tree/submissions/
public class ImplementTriePrefixTree {


    Node root = null;

    public ImplementTriePrefixTree() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++) {
            Node newNode = node.children.get(word.charAt(i));
            if (newNode == null) {
                newNode = new Node();
                node.children.put(word.charAt(i), newNode);
            }
            node = newNode;
        }

        node.end = true;

    }

    public boolean search(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++) {
            Node newNode = node.children.get(word.charAt(i));
            if (newNode == null) return false;
            node = newNode;
        }

        return node.end;

    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i = 0; i < prefix.length(); i++) {
            Node newNode = node.children.get(prefix.charAt(i));
            if (newNode == null) return false;
            node = newNode;
        }

        return true;

    }

    class Node {
        boolean end;
        Map<Character, Node> children = new HashMap<Character, Node>();
    }
}
