package AVLTrees;

// all operations are O(log n)

public class AVLTree<E extends Comparable<E>> {

    private static class Node<E>{
        private E item;
        private Node<E> left, right;
        private int height = 0;
        public Node(E item, Node<E> left, Node<E> right){
            this.item = item;
            this.left = left;
            this.right = right;
        }

        public Node(E item){
            this.item = item;
            this.left = null;
            this.right = null;
        }

        public boolean setLeft (Node<E> node){
            this.left = node;
            return true;
        }

        public boolean setRight (Node<E> node){
            this.right = node;
            return true;
        }
    }

    private Node<E> root;
    public AVLTree(){
        root = null;
    }
    public AVLTree(Node<E> root){
        this.root = root;
        // re-balance
    }

    public void updateHeight(Node<E> node){
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    public int height (Node<E> node){
        if (node == null)
            return -1;
        else return node.height;
    }

    public int getBalance(Node<E> node){
        if (node == null)
            return 0;
        else return height(node.left) - height(node.right);
    }

    public Node<E> rotateRight(Node<E> n){
        Node<E> x = n.left;
        Node<E> y = x.right;
        x.right = n;
        n.left = y;
        updateHeight(n);
        updateHeight(x);
        return x;
    }

    public Node<E> rotateLeft (Node<E> n){
        Node<E> x = n.right;
        Node<E> y = x.left;
        x.left = n;
        n.right = y;
        updateHeight(n);
        updateHeight(x);
        return x;
    }

    // insert node according to BST, then re-balance if need be
    // recursive method, keep calling until you find an empty spot
    public Node<E> insert(Node<E> root, E key){
        if (root == null)
            return new Node(key);

        // go to left, key is less than root
        else if (root.item.compareTo(key) > 0)
            root.left = insert(root.left, key);

        // go to right, key is greater than root
        else if (root.item.compareTo(key) < 0)
            root.right = insert(root.right, key);

        // key value is already in the tree, do not want to store duplicate keys in BST
        else
            throw new RuntimeException("This is a duplicate key");

        return rebalance(root);
    }

    public Node<E> rebalance(Node<E> z){
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1){
            if (height(z.left.right) > height(z.left.left)){
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            } else
                z = rotateRight(z);
        } else if (balance < -1){
            if (height (z.right.left) > height(z.right.right)){
                z.right = rotateRight(z.right);
            }
            z = rotateLeft(z);
        }
        return z;
    }

    private Node<E> mostLeftChild(Node<E> node) {
        Node<E> current = node;
        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // delete node
    public Node<E> delete(Node<E> node, E key) {
        if (node == null) {
            return node;
        } else if (node.item.compareTo(key) > 0) {
            node.left = delete(node.left, key);
        } else if (node.item.compareTo(key) < 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node<E> mostLeftChild = mostLeftChild(node.right);
                node.item = mostLeftChild.item;
                node.right = delete(node.right, node.item);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

}
