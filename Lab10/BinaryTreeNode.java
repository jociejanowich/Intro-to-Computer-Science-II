public class BinaryTreeNode<T> {
    public T element;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T elem){
        element = elem;
        left = null;
        right = null;
    }
}