package SortingAlgorithms;

public class InsertionSort {
    public static<E extends Comparable<E>> E[] sort(E[] table){
        int n = table.length;
        for (int i = 1; i < n; i++){
            int nextPos = i;
            E key = table[i];
            while (nextPos > 0 && table[nextPos - 1].compareTo(key) > 0){
                table[nextPos] = table[nextPos - 1];
                nextPos--;
            }
            table[nextPos] = key;
            for (E k: table)
                System.out.print((Integer)k + " , ");
            System.out.println();
        }
        return table;
    }

    public static void main(String [] args){
        Integer[] array = {40, 20, 35, 19, 25, 12};
        array = InsertionSort.sort(array);
        /*
        System.out.println("Sorted array");
        for (Integer i: array)
            System.out.print(i + " , ");

         */
    }

}
