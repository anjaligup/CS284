/*
@author: Anjali Gupta
I pledge my honor that I have abided by the Stevens Honor System - AG
 */

package HW4.Gupta;

import java.util.Random;
import java.util.Stack;

public class Treap<E extends Comparable<E>>{
    //data fields
    private Random priorityGenerator;
    private Node<E> root;

    public Treap(){
        priorityGenerator = new Random();
    }

    public Treap(long seed){
        priorityGenerator = new Random(seed);
    }


    boolean add(E key){
        int priority = priorityGenerator.nextInt();
        return add(key, priority);
    }


    /*
    adds a node to the treap given its key and priority
     */
    boolean add(E key, int priority){

        if (key == null || priority == 0){
            throw new IllegalArgumentException("Key and priority cannot be null or 0");
        }

        // root is empty, create a new Node with key and priority
        if (root == null) {
            root = new Node<E>(key, priority);
            return true;

        // root is not empty, add node based on BST property, then reheap to restore heap property
        } else {

            Stack<Node<E>> stack = new Stack<>();
            Node<E> curr = root;
            Node<E> nodeToAdd = new Node<E>(key, priority);

            while (curr != null){
                int compare = key.compareTo(curr.data);

                stack.push(curr);

                // if the newNode key is the same as the root key --> node exists
                if (compare == 0) {
                    return false;
                }

                // if the newNode key is less than root key
                if (compare < 0){
                    // if the left node is null, node takes that space
                    if (curr.left == null) {
                        curr.left = nodeToAdd;
                         // call reheap to keep heap properties
                        reheap(stack, nodeToAdd);
                        return true;     // THIS IS WHERE THE PROBLEM HAPPENS?????

                    } else {    //traverse through rest of left subtree to check
                        curr = curr.left;
                    }
                }

                // if the newNode key is greater than root key
                if (compare > 0){

                    //stack.push(curr);
                    // if right node is null, node takes that space
                    if (curr.right == null){
                        curr.right = nodeToAdd;
                        // call reheap to keep heap priorities
                        reheap(stack, nodeToAdd);
                        return true;

                    } else {  // traverse through rest of right subtree to check
                        curr = curr.right;
                    }
                }
            }
        }
        return false;
    }


    /*
    helper function to add that restores heap properties in the treap once a node is added
     */
    private void reheap (Stack<Node<E>> stack, Node<E> newNode){
        Node<E> parent = stack.peek();
        while (!stack.isEmpty()){
            parent = stack.pop();
            if (parent.priority < newNode.priority){
                if (parent.data.compareTo(newNode.data) > 0){
                    newNode = parent.rotateRight();
                } else {
                    newNode = parent.rotateLeft();
                }
                if (!stack.isEmpty()){
                    if (stack.peek().left == parent)
                        stack.peek().left = newNode;
                    else
                        stack.peek().right = newNode;
                } else {
                    root = newNode;
                }

            } else
                break;
        }
    }


    /*
    deletes a node given its key, correct links and properties must be established
    */
    boolean delete(E key) {
        Node<E> parent = null;
        Node<E> curr = root;

        // if node to be deleted is the root
        if (root.data == key) {
            //~insert stuff~
        }

        // find the key that must be deleted, keep updating the curr node and its parent node
        while (curr != null) {
            if (key.compareTo(curr.data) == 0) {
                break;
            } else if (key.compareTo(curr.data) < 0) {
                parent = curr;
                curr = curr.left;
            } else {
                parent = curr;
                curr = curr.right;
            }
        }

        //node is leaf node -- WORKS!!!!
        if (curr.left == null && curr.right == null) {
            if (parent.left == curr) {
                parent.left = null;
                return true;
            } else {
                parent.right = null;
                return true;
            }
            // node has one child -- WORKS
        } else if ((curr.left == null && curr.right != null) || (curr.right == null && curr.left != null)) {
            // need rotation to get curr to become leaf node
            if (curr.left == null) {
                parent.right = curr.rotateLeft();
                parent.right.left = null;
                return true;

            } else {
                parent.right = curr.rotateRight();   // 4's left or 3 becomes null after this rotation ??!!!!!
                parent.right.right = null;
                return true;
            }
            // node has two children -- not done
        } else {
            while (curr.left != null && curr.right != null) {
                if (curr.left.priority < curr.right.priority) {
                    if (parent.right == curr) {
                        parent = curr.rotateRight();
                    } else {
                        parent = curr.rotateRight();
                    }
                } else {
                    if (parent.right == curr){
                        parent = curr.rotateLeft();
                    } else {
                        parent = curr.rotateLeft();
                    }

                    parent = curr.rotateLeft();
                    parent.left = parent.rotateRight();

                }
            }
        }
        return true;
    }



/*
    boolean delete(E key) {
        Node<E> curr = root;
        Node<E> parent = null;
        // Empty BST
        if (root == null) {
            return false;

        } else {   // traverse through tree to find key node to delete
            while (curr.data != key) {
                // if key is less than root, go to left
                if (key.compareTo(curr.data) == 0) {
                    break;
                }
                else if (key.compareTo(curr.data) < 0) {
                    parent = curr;
                    curr = curr.left;

                    // if key is greater than root, go to right
                } else if (key.compareTo(curr.data) > 0) {
                    parent = curr;
                    curr = curr.right;
                }
            }

            // curr is found and node must be removed
            if (curr.left == null && curr.right == null) {
                if (parent.left == curr) {
                    parent.left = curr;
                    return true;
                }
                else {
                    parent.right = curr;
                    return true;
                }
            }else {   // swap node with whichever child has > priority
                if (curr.left.priority < curr.right.priority) {
                    parent = curr;
                    curr = curr.rotateLeft();
                }
                else {
                    parent = curr;
                    curr = curr.rotateRight();
                }
            }
        }
        return false;
    }
 */



    /*
    finds a node given the tree's root and key, return true if found and false if not found
     */
    private boolean find(Node<E> root, E key){
        Node<E> current = root;
        if (root == null || key == null) {
            return false;
        }

        if (root.data == key) {
            return true;

        } else {

            if (key.compareTo(current.data) < 0) {
                return find(current.left, key);
            }
            else {
                return find(current.right, key);
            }
        }
    }

    public boolean find(E key){
        if (key == null){
            throw new IllegalArgumentException("key can not be null");
        } else
            return find(root, key);
    }


    public String toString(){
        return toString(root,0);
    }


    /*
    carries out a preorder traversal of the tree and returns a representation of the nodes as a string
     */
    private String toString(Node<E> current, int level) {
        StringBuilder s = new StringBuilder();
        for(int i=0; i<level; i++) {
            s.append("  ");
        }
        if(current == null)
            s.append("null\n");
        else {
            s.append(current.toString()+"\n");
            s.append(toString(current.left, level+1));
            s.append(toString(current.right, level+1));
        }
        return s.toString();
    }



    private static class Node<E> {
        // data fields
        public E data;  // key for the search --> represents the BST values
        public int priority;  // random heap priority --> represents heap value
        public Node<E> left;
        public Node<E> right;

        public Node(E data, int priority){
            if (data == null || priority == 0)
                throw new IllegalArgumentException("Data and Priority cannot be null!");
            this.data = data;
            this.priority = priority;
            right = null;
            left = null;
        }

        /*
        rotates right and returns a reference to the root of the result
         */
        Node<E> rotateRight(){
            if (left == null)
                return this;
            Node<E> pivot = new Node<E> (this.left.data, this.left.priority);
            pivot.left = this.left.left;
            this.left = this.left.right;
            pivot.right = this;
            return pivot;
        }

        /*
        rotates left and returns a reference to the root of the result
         */
        Node<E> rotateLeft(){
            if (right == null)
                return this;
            Node<E> pivot = new Node<>(this.right.data, this.right.priority);
            pivot.right = this.right.right;
            this.right = this.right.left;
            pivot.left = this;
            return pivot;
        }

        /*
        prints key and priority pairs of a node
         */
        public String toString(){
            return ("(key=" + data + ", " + " priority=" + priority + ")");
        }
    }
}
