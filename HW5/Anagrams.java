package HW5;

/*
@Author: Anjali Gupta
I pledge my honor that I have abided by the Stevens Honor System - AG
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Anagrams {
    final Integer[] primes =
            {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                    31, 37, 41, 43, 47, 53, 59, 61, 67,
                    71, 73, 79, 83, 89, 97, 101};

    // letterTable holds each character and its corresponding prime value
    Map<Character,Integer> letterTable = new HashMap<>();

    /*
    anagramTable holds hash codes (key) and a list of words that have
    the same hashcode --> all words in the list are anagrams of each other
     */
    Map<Long,ArrayList<String>> anagramTable;

    Anagrams() {
        buildLetterTable();
        anagramTable = new HashMap<Long,ArrayList<String>>();
    }

    public void buildLetterTable() {

        char [] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for (int i = 0; i < letters.length; i++){
            letterTable.put(letters[i], primes[i]);
        }
    }

    /*
    adds a word and code pair given a string into anagramTable. If the code already exists,
    it just updates the arrayList of values by adding the string into the anagramTable
     */
    public void addWord(String s) {
        // Complete
        if (s == " ")
            throw new IllegalStateException("Not implemented");

        Long code = myHashCode(s);
        if (anagramTable.containsKey(code)){
            ArrayList<String> string = anagramTable.get(code);
            string.add(s);
        } else {
            ArrayList<String> newString = new ArrayList<>();
            newString.add(s);
            anagramTable.put(code, newString);
        }
    }

    /*
    calculates the hashcode of a given string using prime numbers and corresponding letters
     */
    public long myHashCode(String s) {
        // Complete
        if (s == " ")
            throw new IllegalStateException("Not implemented");
        long value = 1;
        for (int i = 0; i < s.length(); i ++){
            value *= letterTable.get(s.charAt(i));
        }
        return value;
    }

    public void processFile(String s) throws IOException {
        FileInputStream fstream = new FileInputStream(s);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        while ((strLine = br.readLine()) != null)   {
            this.addWord(strLine);
        }
        br.close();
    }

    /*
    returns an arrayList of the entries with the largest number of anagrams
     */
    public ArrayList<Map.Entry<Long,ArrayList<String>>> getMaxEntries() {
        int maxLength = 0;
        Set<Long> listOfKeys = anagramTable.keySet();
        ArrayList<Map.Entry <Long, ArrayList<String>>> newMap = new ArrayList<Map.Entry <Long, ArrayList<String>>>();
        for (Long key : listOfKeys){
            ArrayList<String> listOfValues = anagramTable.get(key);
            int valLength = listOfValues.size();
            if (valLength >= maxLength){
                //why when valLength is greater and equal to maxLength
                maxLength = valLength;
                newMap.clear();
                // add key and listOfValues to newMap hashmap
                newMap.add(new AbstractMap.SimpleEntry<>(key, listOfValues));
            }
        }
        if (newMap.isEmpty())
            throw new IllegalStateException("Not implemented");
        return newMap;
    }


    public static void main(String[] args) {
        Anagrams a = new Anagrams();

        final long startTime = System.nanoTime();
        try {
            a.processFile("/Users/agupt/Documents/words_alpha.txt");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        ArrayList<Map.Entry<Long,ArrayList<String>>> maxEntries = a.getMaxEntries();
        final long estimatedTime = System.nanoTime() - startTime;
        final double seconds = ((double) estimatedTime/1000000000);
        System.out.println("Time: "+ seconds);
        System.out.println("List of max anagrams: "+ maxEntries);
    }
}

