package Stacks;

import java.util.ArrayDeque;

import java.util.Deque;

public class isPalindrome {

    // private constructor

    private isPalindrome(){}

    // fill a stack of characters from input string
    private static Deque<Character> fillStack(String inputString){
        Deque<Character> charStack = new ArrayDeque<>();
        for (int i = 0; i < inputString.length(); i++){
            charStack.push(inputString.charAt(i));
        }
        return charStack;
    }

    /*
    build reverse of a string by pushing them onto a stack
    and then build a string containing the characters in a stack
     */
    private static String buildReverse(String str){
        Deque<Character> charStack = fillStack(str);
        StringBuilder result = new StringBuilder();
        while (!charStack.isEmpty()){
            // Remove top item from stack and append it to result
            result.append(charStack.pop());
        }
        return result.toString();
    }

    public static boolean isPalindrome(String str){
        return str.equalsIgnoreCase(buildReverse(str));
    }



}

