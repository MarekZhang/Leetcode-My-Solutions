/**
 * 17. Letter Combinations of a Phone Number
Medium

3947

412

Add to List

Share
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

 import java.util.*;

class Solution {
    private List<String> res = new ArrayList<String>();

    private String[] letterMapping = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits == "")
            return  res;
        findCombination(digits, 0, "");

        return res;
        
    }

    private void findCombination(String digits, int index, String concactenation){
        if(index == digits.length()){
            res.add(concactenation);
            return;
        }
        char digit = digits.charAt(index);
        String lettersOnNum = letterMapping[digit - '0'];
        for(int i = 0; i < lettersOnNum.length(); i++){
            findCombination(digits, index + 1, concactenation + lettersOnNum.charAt(i));
        }

    }
}