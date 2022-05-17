package problemSet_1;


import java.util.Objects;

public class Main {

    public static void main(String[] arg) {
        System.out.println("wdgfsvf");
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



