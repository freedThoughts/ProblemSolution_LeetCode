package problemSet_1;

import java.util.HashMap;
import java.util.Map;
// https://leetcode.com/problems/design-add-and-search-words-data-structure/submissions/
public class DesignAddAndSearchWordsDataStructure {

    Node root = null;
    public DesignAddAndSearchWordsDataStructure() {
        this.root = new Node();

    }

    public void addWord(String word) {
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
        return search(word, 0, root);
    }

    private boolean search(String word, int index, Node node) {
        if (index == word.length()) return node.end;

        if (node.children.size() == 0) return false;

        if (word.charAt(index) != '.') {
            Node newNode = node.children.get(word.charAt(index));
            if (newNode == null) return false;
            return search(word, index+1, newNode);
        }

        for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
            if (search(word, index+1, entry.getValue())) return true;
        }

        return false;
    }

    class Node {
        boolean end;
        Map<Character, Node> children = new HashMap<>();
    }
}
