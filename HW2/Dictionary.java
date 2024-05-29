// I pledge my honor that I have abided by the Stevens Honor System - AG
package HW2;

import HW2.DictionaryItem;

import java.util.ArrayList;


public class Dictionary {
    private final ArrayList<String> wordList;
    private final ArrayList <DictionaryItem> dicArrayList;

    //initialize arraylist methods with 1300
    public Dictionary(){
        this.wordList = new ArrayList<>(1300);
        this.dicArrayList = new ArrayList<>(1300);
    }

    // adds a word to arraylists wordList and dicArrayList
    public boolean addWordToDictionary(DictionaryItem item){
        wordList.add(item.getWord());
        //System.out.println("Word added: " + item.getWord());
        dicArrayList.add(item);
        return true;
    }

    // prints wordList
    public void printDictionary(){
        //System.out.println(wordList.size());
        for (int i = 0; i < wordList.size(); i++ ) {
            System.out.println(wordList.get(i));
        }
    }

    // checks if a given word exists in wordList
    public boolean hasWord(String word){
        for (int i = 0; i <wordList.size(); i++){
            if (wordList.get(i).equals(word)) {
                return true;
            }
        }
        return false;
    }

    // calls binarySearch() to search for the word in wordList
    public int searchDictionary(String word){
        int index = binarySearch(word, 0, wordList.size());
        if (index == -1){
            return -1; // word not found
        }
        return dicArrayList.get(index).getCount();
    }

    // performs binarySearch method to check if a given word is in the wordList
    // if word is found, a 0 is returned
    // if word is not found, a -1 is returned
    private int binarySearch(String word, int low, int high){
        while (low <= high){
            int mid = low + ((high-low) /2);
            System.out.println("mid value: " + mid);
            String middleWord = wordList.get(mid);
            System.out.println("middleWord: " + middleWord);
            int compare = middleWord.compareTo(word);
            if (compare == 0){
                System.out.println("went into first if statement");
                return mid;
            }
            // string is less than the other string
            else if  (compare < 0){
                return low = mid + 1;
            }
            // string is greater than other string
            else if (compare > 0){
                return high = mid - 1;
            }
        }
        return -1;
    }

}
