package Sets;

import java.util.HashSet;
import java.util.Set;

/*
Notes:
- does not store duplicates
- does not follow order
 */

public class SetExample {
    public static void main(String[] args) {
        String[] listA = {"Ann", "Jill", "Sally", "Sally"};  // does not store duplicates, does not follow order
        String[] listB = {"Ann", "Jill", "Bill", "Bob"};
        Set<String> setA = new HashSet<String>();
        Set<String> setB = new HashSet<String>();
        Set<String> setACopy = new HashSet<String>();

        for (String s: listA){
            setA.add(s);
            setACopy.add(s);
        }

        for (String s: listB){
            setB.add(s);
        }

        System.out.println(setA);
        System.out.println(setB);
        setA.addAll(setB);   // find union of both sets, permanent change, setA now storing union of setA and setB
        System.out.println(setA);
        setACopy.retainAll(setB);
        System.out.println(setACopy);  // intersection between setA and setB


    }
}
