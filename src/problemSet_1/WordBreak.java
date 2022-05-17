package problemSet_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/word-break/
public class WordBreak {


    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        List<Integer> startingIndices = new ArrayList<Integer>();
        startingIndices.add(0);

        boolean[] results = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            String currentString = "";
            for (Integer starting : startingIndices) {
                currentString = s.substring(starting, i+1);
                if (dict.contains(currentString)) {
                    results[i] = true;
                    startingIndices.add(i+1);
                    break;
                }
            }
        }

        return results[s.length()-1];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for(String str : wordDict)
            trie.insert(str, 0);

        return trie.search(s);
    }



    class Trie {

        Node root;

        Trie(){
            root = new Node();
        }

        void insert(String str, int i) {
            Node node = root;
            while(i != str.length()) {
                if (node.children.containsKey(str.charAt(i))) {
                    node = node.children.get(str.charAt(i));
                    i++;
                    continue;
                }
                Node node1 = new Node(i == str.length()-1, new HashMap<Character, Node>());
                node.children.put(str.charAt(i), node1);
                node = node1;
                i++;
            }
            node.end = true;
        }

        boolean search(String str, int i) {
            Node node = root;
            while(i != str.length()) {
                Node node1 = node.children.get(str.charAt(i));
                if (node1 == null) return false;
                if (node1.end && i == str.length()-1) return true;
                if (node1.end && search(str.substring(i+1), i+1)) return true;

                node = node1;
                i++;
            }

            return node.end && i == str.length();
        }


        boolean search(String str) {
            Node node = root;
            for(int i = 0; i < str.length(); i++) {
                if (node.end && search(str.substring(i))) return true;
                Node next = node.children.get(str.charAt(i));
                if (next == null) return false;
                node = next;
            }
            return node.end;
        }


        class Node {
            boolean end;
            Map<Character, Node> children;

            Node() {
                this.end = false;
                this.children = new HashMap<Character, Node>();
            }

            Node(boolean end, Map<Character, Node> children) {
                this.end = false;
                this.children = new HashMap<Character, Node>();
            }
        }
    }
}
