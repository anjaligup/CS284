/*
@Author: Anjali Gupta
I pledge my Honor that I have abided by the Stevens Honor System - AG
 */

package HW3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListQueue <E>{

    private Node<E> front;
    private int size;

    // creates empty single-linked list representing priority queue
    public ListQueue(){
        front = null;
        size = 0;
    }

    /*
    creates one-element linked list representing priority queue
    first parameter will be stored in front
     */
    public ListQueue(Node<E> first){
        front = first;
        size = 1;
    }

    public Node<E> getFront(){
        return front;
    }

    public void setFront(Node<E> front){
        if (size == 0)
            this.front = front;
        Node<E> oldFront = this.front;
        oldFront = front;
        size ++;
    }


    public int getSize(){
        return size;
    }

    /*
    returns the information at the front of the queue
     */
    public E peek(){
        if (size == 0)
            return null;
        return front.data;
    }

    /*
    adds item to a position according to its priority.
    If there exists same-priority tasks in the list, item will be added after the existing
    same-priority level tasks. Throws NullPointerException if the item sent to the method is null.
     */
    public boolean offer(E item, int priority){
        if (item == null){
            throw new NullPointerException();
        }
        Node<E> newNode = new Node<E>(item, priority);
        // list is empty
        if (front == null){
            front = newNode;
            size++;
            return true;
        }
        // if the first element has a higher integer (less priority) than newNode priority
        else if (front.priority > newNode.priority){
            newNode.next = front;
            front = newNode;
            size++;
            return true;
            // go through list until newNode priority is less than node before it
        } else {
            Node<E> curr = front;
            Node<E> prev = null;
            while (curr != null && newNode.priority >= curr.priority ){
                prev = curr;
                curr = curr.next;
            }
            prev.next = newNode;
            newNode.next = curr;
            size++;
        }
        return true;
    }

    /*
    adds item at the end of queue. It always returns true
    except it throws NullPointerException if the item sent to the method is null.
     */
    public boolean addRear(E item) {
        // check if item sent is null
        if (item == null)
            throw new NullPointerException();

        // create a new Node with item given
        Node<E> newNode = new Node(item);

        // if the linked list is empty, front is the newNode
        if (front == null){
            front = newNode;
            size++;
            return true;
        } else {
            Node<E> temp = front;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = null;
            size++;
        }
        return true;
    }

    /*
    returns the data at the front of the queue and removes it from the queue.
    Throws NullPointerException if the item at the front of the queue is null
     */
    public E poll(){
        if (front == null){
            return null;
        }
        E Data = front.getData();
        // remove front node from queue and reassign
        front = front.next;
        size --;
        return Data;
    }

    /*
    takes a node to be removed and removes it from the queue
     */
    public boolean remove(Node<E> tobeRemoved) {
        // list is empty
        if (tobeRemoved == null){
            return false;
        }
        if (front == null) {
            throw new NullPointerException();
        }
        // delete first element
        if (front.getData().equals(tobeRemoved.getData())) {
            front = front.next;
            size--;
            return true;
        }
        Node<E> curr = front;
        Node<E> prev = null;
        while (curr != tobeRemoved && curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null)
            return false;

        //System.out.println("in remove function");
        prev.next = curr.next;
        size --;
        return true;
    }

    /*
    return instance of Iter class
     */
    public Iterator<E> iterator(){
        return new Iter();
    }


    // inner class #1
    public static class Node<E> {
        private E data;
        private Node <E> next;
        private int priority;

        /*
        constructor that creates a node holding dataItem
        No priority given
         */
        public Node(E dataItem){
            this.data = dataItem;
            this.priority = Integer.MAX_VALUE;
        }

        /*
        constructor creates a node holding dataItem, with next as next
        and priority as the priority of the task
         */
        public Node(E dataItem, int priority){
            this.data = dataItem;
            this.priority = priority;
        }

        /*
        constructor creates a node holding dataItem with next as next
        and priority as the priority of the task
         */
        public Node(E dataItem, Node <E> next, int priority){
            this.data = dataItem;
            this.next = next;
            this.priority = priority;
        }

        // will return the data stored in the attribute
        public E getData(){
            return data;
        }

        // return the next node
        public Node<E> getNext(){
            return next;
        }
    }

    // inner class #2
    public class Iter implements Iterator<E> {      // inner class
        private Node <E> next = front;

        // return true when next Node is equal to null
        public boolean hasNext(){
            return next != null;
        }

        /*
        return data stored in the next node attribute and update the
        next node attribute with the next node of the next node
        throw NuSuchElementException if next node is null
         */
        public E next(){
            if (!hasNext())
                throw new NoSuchElementException();
            E nextData = next.getData();
            next = next.getNext();
            return nextData;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
}
