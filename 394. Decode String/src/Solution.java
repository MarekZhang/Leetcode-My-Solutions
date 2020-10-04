/**
 * 394. Decode String
Medium

3740

185

Add to List

Share
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"
 */

class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ']'){
                //decoding
                List<Character> list = new ArrayList<>();
                while(stack.peek()!='[')
                    list.add(0, stack.pop());
                //remove '['
                stack.pop();
                int k = 0;
                int base = 1;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    k = (stack.pop() - '0') * base + k;
                    base *= 10;
                }

                while(k > 0){
                    for(Character c : list)
                        stack.push(c);
                    k--;
                }
            }else{
                stack.push(s.charAt(i));
            }
        }

        char[] charArr = new char[stack.size()];
        for(int i = charArr.length - 1; i >= 0; i--)
            charArr[i] = stack.pop();
        
        return new String(charArr);
    }
}