// I pledge my honor that I have abided by the Stevens Honor System - AG
package HW2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DictionaryCreator {

    Dictionary dict;

    // constructor
    public DictionaryCreator()  {
        dict = readFile("ionDictionary.txt");
        printMenu(dict);
    }

    //constructor with param
    public DictionaryCreator(String filename)  {
        Dictionary dictionary = readFile("ionDictionary.txt");
        printMenu(dictionary);
    }

    // checks if the file exists in the current folder
    public boolean fileExists (String filename) {
        File file = new File("ionDictionary.txt");
        return file.exists();
    }

    // opens the file and reads it, returns the dictionary created
    public Dictionary readFile(String filename){
        Dictionary d = createADictionary();
        File myObj = new File("ionDictionary.txt");
        fileExists("ionDictionary.txt");
        Scanner sc;
        try {
            sc = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        // check empty file
        if (filename.isEmpty()) {
            System.out.println("File is empty");
            return d;
        } else { // if it isn't an empty file
            System.out.println("File not empty");
            for (int i = 0; i < 4; i++) {
                //skip the 4 lines that are unnecessary
                System.out.println("File not empty "+i);
                System.out.println(sc.nextLine());
            }
        }
       // System.out.println("Reading file:" + filename);
        while (sc.hasNextLine()){   // while scanner has a next line to read
            //System.out.println(sc.nextLine());

            DictionaryItem dI = splitWordCountPair(sc.nextLine());
            if (dI != null){
                System.out.println("line read: "+ dI.getWord());
                d.addWordToDictionary(dI);
            }
            else
                System.out.println("dI is null");


        }
        sc.close();
        return d;
    }

    // creates a Dictionary object and returns it
    public Dictionary createADictionary(){
        return new Dictionary();
    }

    // Splits the line read from the file and stores word-count pairs in a new DictionaryItem object
    private DictionaryItem splitWordCountPair(String line) { //scanner contains a word and a number
        //Scanner scan = new Scanner(line);
        //line = scan.nextLine();
        //System.out.println("Line:"+line);
        String [] arr = line.split("\\|");
        //System.out.println("size of array:"+arr.length);
        if (arr.length == 2) {
            try {
                //System.out.println("integer value is :"+arr[1]);
                int i = Integer.parseInt(arr[1].trim());
                System.out.println("1");
                return new DictionaryItem(arr[0], i);

            } catch (NumberFormatException e) {
                //System.out.println("Error has occurred");
                System.out.println("2");
                return null;
            }
        }
        System.out.println("3");
        return null;
    }

    // prints the 3 menu items and takes in user input
    public void printMenu(Dictionary dict){
        int menuItem = 0;
        Scanner scan = new Scanner(System.in);
        try {
            while (menuItem != 3) {
                System.out.println("Please choose one of the following menu items indicated with 1-3");
                System.out.println("1: To print all the words in the dictionary, choose 1");
                System.out.println("2: To search a word in the dictionary, choose 2");
                System.out.println("3: To quit the program, choose 3");
                menuItem = scan.nextInt();
                processMenuItem(menuItem, scan, dict);
            }
        }catch (InputMismatchException e) {
            System.out.println("ERROR! Please enter a number between 1 and 3.");
            scan.nextLine();
            //menuItem = 0;
            printMenu(dict);
        }
    }

    // helper function that takes in input and calls appropriate functions for each operation
    private boolean processMenuItem(int menuItem, Scanner scan, Dictionary dict) {
        if (menuItem < 1 || menuItem > 3){
            System.out.println("ERROR! Please enter a number between 1 and 3.");
        return false;
        }else if (menuItem == 1){
            System.out.println("All the words mentioned in the Ion book!");
            System.out.println("Words");
            System.out.println("-----");
            // System.out.println("file");
            dict.printDictionary();
            return true;
        } else if (menuItem == 2){
            System.out.println("Please enter the word you would like to search:");
            String input = scan.next();
            //dict.searchDictionary(input);
            //System.out.println("Menu option 2 clicked");
            if (dict.searchDictionary(input) == -1){
                System.out.println("The word " + input + " does not exist in the Ion dictionary!");
            } else{
                System.out.println("The word " + input + " occurred " + dict.searchDictionary(input) + " times in the book!");
            }
        } else {
            System.out.println("Thanks for using Ion Dictionary! Bye!");

        }
        return true;
    }


}
