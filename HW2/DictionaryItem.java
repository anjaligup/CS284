// I pledge my honor that I have abided by the Stevens Honor System - AG
package HW2;

public class DictionaryItem {
    private String word;
    private int count;

    //constructor
    public DictionaryItem (String word, int count){
        this.word = word;
        this.count = count;
    }
    // setter for word
    public void setWord (String word){

        this.word = word;
    }
    // getter for word
    public String getWord() {

        return word;
    }
    // setter for count
    public void setCount (int count) {

        this.count = count;
    }
    // getter for count
    public int getCount() {

        return count;
    }


}
