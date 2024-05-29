package Queues;


import java.util.AbstractQueue;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Iterator;


public class QueueList<E> extends AbstractQueue<E> implements Queue<E>{
    private static class Node<E>{
        private E data;
        private Node<E> next;

        private Node(E dataItem){
            data = dataItem;
            next = null;
        }

        private Node(E dataItem, Node<E> ref){
            data = dataItem;
            next = ref;
        }
    }

    private Node<E> front;
    private Node<E> rear;
    private int size;

    @Override
    public E peek(){
        if (size == 0)
            return null;
        return front.data;
    }

    public boolean offer(E item){
        if (item == null)
            return false;
        if (front == null) { //or if size == 0
            front = new Node<E>(item);
            rear = front;
        }else{
            rear.next = new Node<E>(item);
            rear.next = rear;
        }
        size++;
        return true;
    }

    @Override
    public E poll(){ // return and remove the first element in queue
        E item = peek();
        if (item == null)
            return null;
        front = front.next; // reassign the front node to the next node
        size --;
        return item; // return the first item of the queue
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public Iterator<E> iterator(){
        return new Iter();
    }

    private class Iter implements Iterator <E>{
        Node<E> next = front;

        @Override
        public boolean hasNext(){ // if we have a next item available
            return next != null;
        }

        @Override
        public E next(){
            if(next == null)
                throw new NoSuchElementException();
            E item = next.data; // next is showing current
            next = next.next;
            return item;
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Move the element at the front of the queue to the rear
     * Does nothing if the queue is empty or has only one item
     */

    public void moveToRear(){
        if (front == null || front.next == null) // if the queue has an element of 1 or is null
            return;
        Node <E> oldFront = front;
        front = front.next;
        rear.next = oldFront;
        rear = rear.next;
        rear.next = null; // stops the code from being a circular queue

        /*
        rear.next = front;
        front = front.next;
        rear = rear.next;   
         */
    }

    /* implementation of circular array
    public boolean offer (E item){
        if (size == capacity){
            reallocate():
        }
        size ++;
        rear = (rear + 1) % capacity;   --> modulus finds the spot to put the new item in
        theData[rear] = item;
        return true;
    }
     */


}
