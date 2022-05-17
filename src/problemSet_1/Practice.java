package problemSet_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Practice {

    //Trie trie;
    //TrieZalando trieZalando = null;

/*     * index.add("Hello");i
 * index.add("Hi");
 * index.add("Goodbye");
 * index.add("Hierarchy");*/

    static TrieZalando trieZalando = new TrieZalando();

    public static void main(String[] arg) {

        //TrieZalando trieZalando = new TrieZalando();
        trieZalando.add("Hi");
        trieZalando.add("Hierarchy");

        System.out.print(trieZalando.find("XX"));

        //trieZalando.n


    }

/*    void add(String token){


    }

    String[] find(String prefix){

    }*/

    class Trie {

        Node root;

        void add(String token){

            Node node = root;
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


        List<String> find(String prefix){
            Node node = root;
            for(int i = 0; i < prefix.length(); i++) {
                node = node.children.get(prefix.charAt(i));
            }

            List<String> results = new ArrayList<>();
            backTrack(results, prefix, node);

            return results;

        }


        void backTrack(List<String> results, String str, Node node){
            if(node.eof) {
                results.add(str);
            }
            for(Map.Entry<Character, Node> entry : node.children.entrySet()){

                backTrack(results, str + entry.getKey(), entry.getValue());
            }
        }


        class Node {
            //Character ch;
            Map<Character, Node> children;
            boolean eof;

        }
    }
}


// H --> i
//    --> e

// i --> h
// e --> f