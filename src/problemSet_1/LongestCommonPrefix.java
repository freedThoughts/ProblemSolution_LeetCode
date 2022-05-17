package problemSet_1;

import java.util.HashMap;
import java.util.Map;
// https://leetcode.com/problems/longest-common-prefix/submissions/
public class LongestCommonPrefix {

    public String longestCommonPrefix2(String[] str) {
        int unmatchedIndex = str[0].length();
        for(int i = 1; i < str.length; i++) {
            int j = 0;
            while(str[0].length() > j && str[i].length() > j && str[0].charAt(j) == str[i].charAt(j)) {
                j++;
            }
            unmatchedIndex = Math.min(unmatchedIndex, j);
        }

        return str[0].substring(0, unmatchedIndex);
    }

    public String longestCommonPrefix(String[] str) {
        Trie trie = new Trie();
        trie.insert(str[0]);
        int ans = str[0].length();
        for(int i = 1; i < str.length; i++)
            ans = Math.min(ans, trie.getUnmatchedIndex(str[i]));
        return str[0].substring(0, ans);
    }

    class Trie{
        Node root = new Node();

        void insert(String str){
            Node node = root;
            for(int i = 0; i < str.length(); i++) {
                if(node.children.containsKey(str.charAt(i))) {
                    node = node.children.get(str.charAt(i));
                    continue;
                }

                Node newNode = new Node();
                node.children.put(str.charAt(i), newNode);
                node = newNode;
            }
            node.eof = true;
        }

        int getUnmatchedIndex(String str) {
            Node node = root;
            int i = 0;
            for(; i < str.length(); i++) {
                if (node.children.containsKey(str.charAt(i))) {
                    node = node.children.get(str.charAt(i));
                    continue;
                }
                return i;
            }
            return i;
        }
    }

    class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean eof;
    }
}
