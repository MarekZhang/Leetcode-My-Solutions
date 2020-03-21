/*125. Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/

public class Solution{
    public static boolean isPalindrome(String s) {
        if(s.equals(""))
            return true;
        
        s = s.replaceAll("[^A-Za-z0-9]","");
        if(s.equals(""))//all spaces
             return true;
         s = s.toLowerCase();
         int N = s.length();
         int i = 0;
         int j = N - 1;
         while(s.charAt(i++) == s.charAt(j--)){
             i ++;
             j --;
             if( i >= j)
                 return true;
         }   
         return false;
     }

    public static void main(String args[]){
        String s = "  ";
        boolean t = isPalindrome(s);
        System.out.println(t);
    }
}