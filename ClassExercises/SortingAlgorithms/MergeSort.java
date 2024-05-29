package SortingAlgorithms;

public class MergeSort {


    // non-static methods: used for object-related things
    public static void sort(int[] table){   // not object specific, can be applied to anything
        if(table.length < 1){
            int halfSize = table.length / 2;
            int[] leftTable = new int[halfSize];
            int[] rightTable = new int[halfSize];
            System.arraycopy(table, 0, leftTable, 0, halfSize);
            System.arraycopy(table, halfSize, rightTable, 0, table.length - halfSize);

            sort(leftTable);
            sort(rightTable);
            merge(table, leftTable, rightTable);
        }
    }

    private static void merge(int[] output, int[] left, int[] right){
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < left.length && j < right.length){
            if (left[i] < right[j])
                output[k++] = left[i++];
            else output[k++] = right[j++];
        }
        while(i < left.length){
            output[k++] = left[i++];
        }

        while(j < right.length) {
            output[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 6, 3, 1, 7};
        sort(array);
        for (int i: array)
            System.out.println(i + ",");
    }
}
