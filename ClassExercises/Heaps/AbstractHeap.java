package Heaps;

import java.util.ArrayList;
public abstract class AbstractHeap<E> {
    private ArrayList<E> theData;
    public AbstractHeap(){
        theData = new ArrayList<E>(10);
    }

    public AbstractHeap(int initialCapacity){
        theData = new ArrayList<E>(initialCapacity);
    }

    protected abstract int compare(E e1, E e2);    // --> compare two different generics/items *can also use comparable interface in class definition

    public boolean offer(E item){
        theData.add(item);

        int child = theData.size() - 1;  // 13

        // calculate parent index
        int parent = (child - 1) / 2; // 6

        while (parent >= 0 && compare(theData.get(parent), theData.get(child)) > 0){
            swap(parent, child);
            child = parent; // 6
            parent = (child - 1) / 2;  // 2
        }
        return true;
    }

    public E poll() {
        if (isEmpty())
            return null;
        E result = theData.get(0);
        if(theData.size() == 1){
            theData.remove(0);
            return result;
        }
        swap(0, theData.size() - 1);
        theData.remove(theData.size() - 1);

        int parent = 0;

        while(true){
            int leftChild = 2 * parent + 1;
            if (leftChild >= theData.size())
                break;
            int minChild = leftChild;
            int rightChild = leftChild + 1;
            if (rightChild < theData.size() && compare(theData.get(leftChild), theData.get(rightChild)) > 0){
                minChild = rightChild;
            }
            if (compare(theData.get(parent), theData.get(minChild)) > 0){
                swap(parent, minChild);
                parent = minChild;
            } else break;
        }
        return result;

    }



    private void swap(int a, int b){  // a = 13, b = 6
        E temp = theData.get(a);  // temp = 13th index
        theData.set(a, theData.get(b)); // 13 <- 6
        theData.set(b, temp); // 6 <- temp
    }

    public boolean isEmpty() {
        return theData.size() == 0;
    }




}
