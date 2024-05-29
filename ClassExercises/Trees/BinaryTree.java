package Trees;


// Integers have built in compare, so does String
public class BinaryTree<E extends Comparable<E>>{
    // define node class and initialize variables and constructors specific to Node
    public class Node<E> {
        private E data;
        private Node<E> left;
        private Node<E> right;

        public Node (E data){
            this.data = data;
            this.right = null;
            this.left = null;
        }

        public Node (E data, Node<E> left, Node<E> right){
            this.data = data;
            this.right = right;
            this.left = left;
        }
    }

    // variables specific to BinaryTrees
    private Node<E> root;
    private int size;

    BinaryTree(){
        root = null;
        size = 0;
    }

    BinaryTree(E data){
        root = new Node<E>(data);
        size = 1;
    }

    private int height(Node<E> current){
        if (current == null)
            return -1;
        return 1 + Math.max(height(current.left), height(current.right));
    }

    /**
     * Get the level of a data value --> how many edges from the node to the last node in the path
     * @return -1 if the data was not found, otherwise it will return the level
     */

    // helper method for getLevel(E data)
    private int getLevel(Node<E> node, E data, int level){
        if (node == null)
            return -1;   // --> return -1 because we are starting at level 0; return would be 0 if we were starting at 1
        if (data.compareTo(node.data) == 0)
            return level;
        int downLevel = getLevel(node.left, data, level + 1);
        if (downLevel != -1)
            return downLevel;
        downLevel = getLevel(node.right, data, level + 1);
        return downLevel;
    }


    public int getLevel(E data){
        // overloaded method call
        return getLevel(root, data, 0);
    }


    /**
     * Determines if the node is a leaf --> node does not have any left or right children
     * @return
     */
    public boolean isLeaf(Node<E> current){

        return current.left == null && current.right == null;
    }
}
