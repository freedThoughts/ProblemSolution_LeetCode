package outfittery;


/*



                    a
                /       \
               b         c
                 \    /    \
                 e   f      g
                /          /   \
                k         h     i
                  \           /
                    r        j
                   /  \
                   l   m


find the min number of cameras that will be required to cover this binary tree

 */

public class Main {

    public static void main(String[] args) {
        System.out.println("dvdfbaa");

    }


    int minCamera(TreeNode root) {
        int[] val = cameraReq(root);
        return Math.min(val[0], val[1]);
    }

    // 0 -- withameraInstall
    // 1 -- withoutCameraInstall
    int[] cameraReq(TreeNode node){

        if (node == null) return new int[]{0,0};


        int[] leftTree = cameraReq(node.left);
        int[] rightTree = cameraReq(node.right);


        // install at node
        int with =  1 + Math.min(leftTree[1] + rightTree[1],leftTree[0] + rightTree[0] );

        // dont indtall at node
        int without = leftTree[0] + rightTree[0];



        return new int[]{with, without};
    }


    class TreeNode {

        TreeNode left;
        TreeNode right;

    }

}
