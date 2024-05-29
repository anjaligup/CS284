package Heaps;

public class Max_Heaps {

    /*
    given max-heap with N nodes:
    height:
    floor of logN
    insertion:
    word case: O(logN)
    removal:
    average: O(logN)


    MINI-HEAP
    customer with lower number = higher priority
    heap removal operation: O(logN)

    MIN Heap insertion:
    best case insertion: O(1)
    worst case insertion: O(h)    h is height of tree
    average case insertion: O(logN)

    removal:
    Remove the item in the root by replacing it with the last item
    while (item LIH has children and it is larger than either
        Swap item LIH with its smaller child moving LIH down

    removal O(logN)


    insertion of min heap
    while (parent >= 0 and table[parent]> table[child]{
        swap(table[parent], table[child])   --> swap values
        child = parent    --> swap indexes
        parent = (child-1)/2

    removal
    table[0] = le
    parent = 0
    while (true){
        leftChild = 2*parent + 1
        rightChild = leftChild + 1
        if (leftChild>= table.size())
            break out of loop
        minChild = leftChild
        if (rightChild < table.size() and table[rightChild] < table[leftChild]
            minChild = rightChild
    }

     */
}
