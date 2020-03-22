/*
345. Reverse Vowels of a String
Easy

555

989

Add to List

Share
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".
*/

public class Solution{
    public static String reverseVowels(String s) {
        if(s.equals(""))
            return s;

        char[] arr = s.toCharArray();
        int N = arr.length;
        int i = 0;
        int j = N - 1;
        
        while(true){
            while(i <= N - 1 && !isVowel(arr[i]))
                i++;
            while(j >= 0 && !isVowel(arr[j]))
                j--;
            if(i >= j)
                break;
            swap(arr, i++, j--);
            
        }
        return String.valueOf(arr);
    }

    private static void swap(char[] arr, int i, int j){
        char tempt = arr[i];
        arr[i] = arr[j];
        arr[j] = tempt;
    }

    private static boolean isVowel(char ch){
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || 
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
    }


    public static void main(String args[]){
        String s = "hello";
        s = reverseVowels(s);
        System.out.println(s);
    }
}