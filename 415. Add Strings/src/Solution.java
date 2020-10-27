/**
 * 415. Add Strings
Easy

1276

314

Add to List

Share
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int carry = 0;
        
        while(p1 >= 0 || p2 >= 0){
            int digit1 = p1 >= 0 ? num1.charAt(p1--) - '0' : 0;
            int digit2 = p2 >= 0 ? num2.charAt(p2--) - '0' : 0;
            int tempt = digit1 + digit2 + carry;
            carry = tempt >= 10 ? 1 : 0;
            builder.append(tempt % 10);
        }
        
        if(carry == 1)
            builder.append(1);
        
        builder = builder.reverse();
        
        return builder.toString();
    }
}