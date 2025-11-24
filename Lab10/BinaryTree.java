public class BinaryTree<T extends Comparable<T>> {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.left = new BinaryTreeNode<>(5);
        root.right= new BinaryTreeNode<>(15);
        root.left.left = new BinaryTreeNode<>(3);
        root.left.right = new BinaryTreeNode<>(7);
        root.right.right = new BinaryTreeNode<>(20);

        BinaryTree<Integer> tree = new BinaryTree<>(root);

        System.out.println("Is BST? " + tree.isBinarySearchTree());
        System.out.println("Total nodes: " + tree.treeNodeCount()); 

        
        System.out.println("Total leaves: " + tree.treeLeavesCount()); 

       
        BinaryTreeNode<Integer> root2 = new BinaryTreeNode<>(1);
        root2.left = new BinaryTreeNode<>(2);
        root2.right = new BinaryTreeNode<>(3);
        root2.left.left = new BinaryTreeNode<>(4);
        root2.left.right = new BinaryTreeNode<>(5);
        root2.right.right = new BinaryTreeNode<>(6);

        BinaryTree<Integer> tree2 = new BinaryTree<>(root2);

        
        System.out.println("Trees have similar shape? " + tree.similarTrees(tree2));
    }

    final private BinaryTreeNode<T> root;

    public BinaryTree(){
        root = null;
    }

    public BinaryTree(BinaryTreeNode<T> root){
        this.root = root;
    }
    
    public boolean isBinarySearchTree() {
        return isBST(root);
    }

    public boolean isBST(BinaryTreeNode<T> tree) {
        if (tree == null) return true;
        if (tree.left != null && findMax(tree.left).compareTo(tree.element) > 0) return false;
        if (tree.right != null && findMin(tree.right).compareTo(tree.element) < 0) return false;
        return isBST(tree.left) && isBST(tree.right);
    }

    private T findMax(BinaryTreeNode<T> tree) {
        while (tree.right != null)
            tree = tree.right;
        return tree.element;
    }

    private T findMin(BinaryTreeNode<T> tree) {
        while (tree.left != null)
            tree = tree.left;
        return tree.element;
    }

    public boolean similarTrees(BinaryTree<T> otherTree){
        return similar(this.root, otherTree.root);
    }

    private boolean similar(BinaryTreeNode<T> tree1, BinaryTreeNode<T> tree2){
        if (tree1 == null & tree2 ==null) return true;
        if (tree1 == null || tree2 == null) return false;
        return similar(tree1.left, tree2.left) && similar(tree1.right, tree2.right);
    }

    public int treeNodeCount(){
        return nodeCount(root);
    }

    private int nodeCount(BinaryTreeNode<T> t){
        if (t == null) return 0;
        return 1 + nodeCount(t.left) + nodeCount(t.right);
    }

    public int treeLeavesCount(){
        return leavesCount(root);
    }

    private int leavesCount(BinaryTreeNode<T> t){
        if (t == null) return 0;
        if (t.left == null && t.right == null) return 1;
        return leavesCount(t.left) + leavesCount(t.right);
    }

}
