package ExtraHW;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class CountingSortTest {
    @Test
    void Test1(){
        CountingSort cs = new CountingSort();
        int [] SortedArray = {1, 3, 8, 10, 12, 30, 67};
        int [] b = {10, 30, 3, 67, 1, 8, 12};
        b = cs.sort(b);
        assertEquals(Arrays.toString(SortedArray), Arrays.toString(b));
    }


    @Test
    void Test2(){
        CountingSort cs = new CountingSort();
        int [] SortedArray = {1, 2, 3, 4, 5, 6};
        int [] b = {4 ,3, 2, 1, 5, 6};
        b = cs.sort(b);
        assertEquals(Arrays.toString(SortedArray), Arrays.toString(b));
    }


    @Test
    void Test3(){
        CountingSort cs = new CountingSort();
        int [] SortedArray = {3, 5, 50, 67, 98, 100};
        int [] b = {100, 50, 67, 3, 5, 98};
        b = cs.sort(b);
        assertEquals(Arrays.toString(SortedArray), Arrays.toString(b));
    }


    @Test
    void Test4(){
        CountingSort cs = new CountingSort();
        int [] SortedArray = {45, 46, 47, 48, 49};
        int [] b = {49, 48, 47, 46, 45};
        b = cs.sort(b);
        assertEquals(Arrays.toString(SortedArray), Arrays.toString(b));
    }

}
