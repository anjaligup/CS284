package Sets;

import java.io.*;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// put words in word-count pairs

public class MapChallenge {
    public static void main(String[] args){
        File f = new File("/Users/agupt/Downloads/README.txt");
        Scanner scanner;
        HashMap<String, Integer> wordList = new HashMap<String, Integer>();
        try {
            scanner = new Scanner(f);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] words = line.replaceAll("\\p{Punct}", "").split("\\s+");
                for(int i = 0; i<words.length; i++)
                {
//                    System.out.println(words[i]);
                    if(wordList.containsKey(words[i].toLowerCase())) {
                        int count = wordList.get(words[i].toLowerCase());
                        wordList.put(words[i].toLowerCase(), ++count);
                    }else wordList.put(words[i].toLowerCase(), 1);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        scanner.close();
        for(String key : wordList.keySet()){
            System.out.println(key+" "+wordList.get(key));
        }

    }
}



        /*

        String filename = "/Users/agupt/Downloads/README.txt ";
        Map<String, Integer> wordCount = new HashMap<String, Integer>();


        for (String word : wordCount.keySet()) {
            System.out.println(word + ":" + wordCount.get(word));
        }

        try (BufferedReader br = new BufferedReader((new FileReader(filename)))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.replaceAll("[a-zA-Z]", "").toLowerCase();
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


        File myobj = new File("/Users/agupt/Downloads/README.txt ");
        Map<String, Integer> map = new HashMap<String, Integer>();

        try {
            Scanner scan = new Scanner(myobj);
            while (scan.hasNextLine()){
                String word = scan.next();


            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

         */






