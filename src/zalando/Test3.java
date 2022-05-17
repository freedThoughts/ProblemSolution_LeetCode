package zalando;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// Performance 3/4 passed
// Rest Correctness -- all good
public class Test3 {

    public boolean solution(String[] B) {

        Set<Node> sightSet = new HashSet<>();

        for(int i = 0; i < B.length; i++) {
            for(int j = 0; j < B[0].length(); j++) {
                char ch = B[i].charAt(j);
                if (ch == '<' || ch == '>' || ch == '^' || ch == 'v') {
                    if (markSight(i, j, ch, B, sightSet)) return false;
                }
            }
        }

        return isFesible(B.length-1, B[0].length()-1, B, sightSet);
    }

    boolean isFesible(int i, int j, String[] B, Set<Node> sightSet) {
        if (i < 0 || i == B.length || j < 0 || j == B[0].length()) return false;
        char currentChar = B[i].charAt(j);

        if (currentChar == 'X' || currentChar == '<' || currentChar == '>' || currentChar == '^' || currentChar == 'v' || sightSet.contains(new Node(i, j))) return false;

        if (currentChar == 'A') return true;
        sightSet.add(new Node(i, j));

        if (isFesible(i+1, j, B, sightSet)) return true;
        if (isFesible(i-1, j, B, sightSet)) return true;
        if (isFesible(i, j+1, B, sightSet)) return true;
        if (isFesible(i, j-1, B, sightSet)) return true;

        return false;
    }

    boolean markSight(int i, int j, char ch, String[] B, Set<Node> sightSet ){
        if (ch == '<') {
            j--;
            while(j >= 0) {
                char currentChar = B[i].charAt(j);
                if (currentChar == 'A') return true;
                if (currentChar == 'X' || currentChar == '<' || currentChar == '>' || currentChar == '^' || currentChar == 'v') break;

                sightSet.add(new Node(i, j));
                j--;
            }
        } else if (ch == '>'){
            j++;
            while(j < B[0].length()) {
                char currentChar = B[i].charAt(j);
                if (currentChar == 'A') return true;
                if (currentChar == 'X' || currentChar == '<' || currentChar == '>' || currentChar == '^' || currentChar == 'v') break;

                sightSet.add(new Node(i, j));
                j++;
            }

        } else if (ch == '^') {
            i--;
            while(i >= 0) {
                char currentChar = B[i].charAt(j);
                if (currentChar == 'A') return true;
                if (currentChar == 'X' || currentChar == '<' || currentChar == '>' || currentChar == '^' || currentChar == 'v') break;

                sightSet.add(new Node(i, j));
                i--;
            }

        } else if (ch == 'v'){
            i++;
            while(i < B.length) {
                char currentChar = B[i].charAt(j);
                if (currentChar == 'A') return true;
                if (currentChar == 'X' || currentChar == '<' || currentChar == '>' || currentChar == '^' || currentChar == 'v') break;

                sightSet.add(new Node(i, j));
                i++;
            }
        }

        return false;
    }

    class Node {
        Integer row;
        Integer col;
        Node(Integer row, Integer col){
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return row.equals(node.row) &&
                    col.equals(node.col);
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
