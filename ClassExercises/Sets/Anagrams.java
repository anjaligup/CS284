package Sets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// write method to sort an array of strings so that all anagrams are next to eachother
public class Anagrams {


    // function that takes in two strings and returns true if both are anagrams, false if not
    boolean isAnagram(String stringOne, String stringTwo) {
        char[] StringOneCount = new char[stringOne.length()];
        char[] StringTwoCount = new char[stringTwo.length()];
        int i;
        for (i = 0; i < stringOne.length() && i < stringTwo.length(); i++) {
            StringOneCount[i] = stringOne.charAt(i);
            StringTwoCount[i] = stringTwo.charAt(i);
        }

        if (StringOneCount.length != StringTwoCount.length) {
            return false;
        }

        Arrays.sort(StringOneCount);
        Arrays.sort(StringTwoCount);

        for (i = 0; i < StringOneCount.length; i++) {
            if (StringOneCount[i] == StringTwoCount[i]) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}

/*
    void sortArray(String words[]){
        Map<String, String> map = new HashMap<>();
        for (String wrd : words) {
            char [] charArray = wrd.toCharArray();
            Arrays.sort(charArray);
            String sortedString = charArray.toString();

            if (map.containsKey(sortedString)){
                map.get(sortedString);
            }
        }

    }



    public static void main(String[] arr) {
        Anagrams test = new Anagrams();
        String[] arr = {"listen", "silent", "enlist", "hello", "world", "dog", "god"};
        System.out.println(test.isAnagram("listen", "silent"));

    }

}

 */
