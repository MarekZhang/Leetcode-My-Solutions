/**
 * 93. Restore IP Addresses
Medium

1273

502

Add to List

Share
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

A valid IP address consists of exactly four integers (each integer is between 0 and 255) separated by single points.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
 */
import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<Integer> ip = new ArrayList<>();
        dfs(s, 0, ip, res);
        return res;
    }

    private void dfs(String s, int index, List<Integer> ip, List<String> res){
        if(index == s.length()){
            if(ip.size() == 4)
                res.add(getString(ip));
            return;
        }

        if(index == 0){
            ip.add(s.charAt(0) - '0');
            dfs(s, index + 1, ip, res);
        }else{
            int lastElement = ip.get(ip.size() - 1);
            int next = lastElement * 10 + (s.charAt(index) - '0');
            if(next <= 255 && lastElement != 0){
                ip.set(ip.size() - 1, next);
                dfs(s, index + 1, ip, res);
                ip.set(ip.size() - 1, ip.get(ip.size() - 1) / 10);
            }
            if(ip.size() < 4){
                ip.add(s.charAt(index) - '0');
                dfs(s, index + 1, ip, res);
                ip.remove(ip.size() - 1);
            }
        }

    }

    private String getString(List<Integer> ip){
        String res = "" + ip.get(0);
        for(int i = 1; i < ip.size(); i++)
            res += "." + ip.get(i);
        return res;
    }

    public static void main(String[] args){
        String s1 = "25525511135";
        new Solution().restoreIpAddresses(s1);
    }
}