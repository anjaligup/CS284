package HW5;

/*
@Author: Anjali Gupta
I pledge my honor that I have abided by the Stevens Honor System - AG
 */

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramsTest {
    @Test
    void Test1(){
        Anagrams anagram = new Anagrams();
        anagram.addWord("alerts");
        anagram.addWord("alters");
        anagram.addWord("talers");
        Long aWords = 236204078L;
        assertEquals(aWords, anagram.myHashCode("alerts"));
    }

    @Test
    void Test2(){
        Anagrams anagram = new Anagrams();
        anagram.addWord("dog");
        anagram.addWord("god");
        anagram.addWord("odg");
        anagram.addWord("gdo");
        Long dWords = 5593L;
        assertEquals(dWords, anagram.myHashCode("dog"));
    }

    @Test
    void Test3(){
        // test given in original template
        Anagrams a = new Anagrams();

        final long startTime = System.nanoTime();
        try {
            a.processFile("/Users/agupt/Documents/words_alpha.txt");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        ArrayList<Map.Entry<Long, ArrayList<String>>> maxEntries = a.getMaxEntries();
        final long estimatedTime = System.nanoTime() - startTime;
        final double seconds = ((double) estimatedTime/1000000000);
        System.out.println("Time: "+ seconds);
        System.out.println("List of max anagrams: "+ maxEntries);
    }

}
