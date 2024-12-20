package Tree;

public class App {
    public static void main(String[] args) {
        System.out.println("sds");

        Tree<Integer> tree = new Tree<Integer>();

        tree.root = new TreeNode<Integer>(15);
        tree.root.left = new TreeNode<Integer>(10);
        tree.root.right = new TreeNode<Integer>(25);

        tree.root.left.left = new TreeNode<Integer>(8);
        tree.root.left.right = new TreeNode<Integer>(12);

        tree.root.right.left = new TreeNode<Integer>(17);
        tree.root.right.right = new TreeNode<Integer>(50);



        tree.PreOrderR(tree.root);
         System.out.println(" ");
        // tree.PreOrderI(tree.root);

        // tree.InOrderR(tree.root);
        // System.out.println(" ");
        // tree.InOrderI(tree.root);

        tree.PostOrderR(tree.root);
        System.out.println(" ");
        tree.PostOrderI(tree.root);




    }
}
