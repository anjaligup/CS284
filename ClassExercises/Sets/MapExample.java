package Sets;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<String, String> aMap = new HashMap<String, String>();
        aMap.put("A", "Apple");
        aMap.put("B", "Ball");
        aMap.put("C", "Cat");
        aMap.put("D", "Duck");

        System.out.println(aMap.get("D"));  // prints Duck
        System.out.println(aMap.keySet());  // prints the set of all keys
        System.out.println(aMap.values());  // prints set of all values
        System.out.println(aMap.containsKey("Z"));  // check if specific key is contained

    }
}
