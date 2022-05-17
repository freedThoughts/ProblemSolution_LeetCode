package problemSet_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieZalando {
    Node root = new Node();


    synchronized void add(String token){

        Node node = root = new Node();
        for(int i = 0; i < token.length(); i++){
            if (node.children.containsKey(token.charAt(i))){
                node = node.children.get(token.charAt(i));
                continue;
            }
            Node newNode = new Node();
            node.children.put(token.charAt(i), newNode);
            node = newNode;
        }

        node.eof = true;
    }

// Read
    List<String> find(String prefix){
        Node node = root;
        for(int i = 0; node != null && i < prefix.length(); i++) {
            node = node.children.get(prefix.charAt(i));
        }

        List<String> results = new ArrayList<>();

        if (node == null) return results;
            backTrack(results, prefix, node);

        return results;

    }


    void backTrack(List<String> results, String str, Node node){
        if(node == null) return;
        if(node.eof) {
            results.add(str);
        }
        for(Map.Entry<Character, Node> entry : node.children.entrySet()){

            backTrack(results, str + entry.getKey(), entry.getValue());
        }
    }


    private class Node {
        //Character ch;
        private Map<Character, Node> children;
        private boolean eof;

        Node(){
            this.children = new HashMap<>();
        }

        public void setChildren(Map<Character, Node> children) {
            this.children = children;
        }

        public void setEof(boolean eof) {
            this.eof = eof;
        }

        public Map<Character, Node> getChildren() {
            return children;
        }

        public boolean isEof() {
            return eof;
        }
    }
}
