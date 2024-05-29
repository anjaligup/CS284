package Arrays;

public class JavaIntro {
    public static void main(String[] args) {
        System.out.println("Hello World");

        // Arrays class exercises 1/24
        int[] scores = new int[5];
        for (int i=0; i<5; i++) {
            System.out.println(scores[i]); //prints five zeros
        }

        int [] nums = {1, 3, 5};
        int nums2 [] = {2, 4, 6};

        System.out.println(nums.length); //prints length of array nums


        final int Rows = 3;
        final int Cols = 3;
        double [][] matrix = new double [Rows][Cols];

        for (int i=0; i< Rows; i++) {
            for (int j=0; j<Cols; j++) {
                System.out.println(matrix[i][j]);
            }
        }

        int item = 42;
        double realItem = item; //this is valid

        double y = 3.14;
        int x = (int) y; // not valid, need type conversion

        String num = "10";
        int newNum = Integer.parseInt(num); //Integer is wrapper class
        //System.out.println(newNum);



    }
}
