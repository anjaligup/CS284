package SortingAlgorithms;

public class BubbleSort {
    public static <E extends Comparable<E>> E[] sort(E[] table) {
        int pass = 1;
        boolean exchanges;
        do {
            exchanges = false;
            for (int i = 0; i < table.length - pass; i++) {
                if (table[i].compareTo(table[i + 1]) > 0) {
                    E temp = table[i];
                    table[i] = table[i + 1];
                    table[i + 1] = temp;
                    exchanges = true;
                }
            }
            pass++;  // --> indicates how many times loop runs
            for (E element : table)
                System.out.print((Integer) element + ",");
                System.out.println();

        } while (exchanges);
        return table;
    }

    public static void main(String[] args) {
        Integer[] array = {5, 7, 2, 4, 3};
        array = BubbleSort.sort(array);
        //System.out.println(array);
    }
}
