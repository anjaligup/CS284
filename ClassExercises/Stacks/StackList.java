package Stacks;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class StackList <E> {

    private static class Node<E> { // create Nodes embedded within Stack class, make it private and static
        private E data;
        private Node<E> next;

        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }

    private Node<E> topOfStack;

    private int size = 0;

    public StackList() {
        topOfStack = null;
    }

    public StackList(E[] data) {
        topOfStack = null;
        for (E item : data) {
            push(item);
        }
    }

    public E push(E obj) {
        if (obj == null)
            throw new InputMismatchException("You cannot add null element to the stack!");
        topOfStack = new Node(obj, topOfStack);
        size++;
        return obj;
    }

    public E peek() { // top of stack data is shown
        if (topOfStack == null)
            throw new NoSuchElementException();
        return topOfStack.data;
    }

    public E pop() {  // data of item after item before that is removed
        if (topOfStack == null)
            throw new NoSuchElementException();
        E oldData = topOfStack.data; // garbage collection of original topOfStack
        topOfStack = topOfStack.next;
        size--;
        return oldData;
    }

    public boolean empty() { // checks if stack is empty
        return topOfStack == null;
    }

    char myChar = 'c';
    String myString = "hello";

}
