class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        Set<Character> set = new HashSet<>();
        int p1 = 0, p2 = 0, res = 0;
        while(p2 < s.length()){
            char c = s.charAt(p2);
            if(!set.contains(c)){
                set.add(c);
                p2++;
            }else{
                set.remove(s.charAt(p1));
                p1++;
            }
            
            res = Math.max(res, p2 - p1);
        }
        
        return res;
    }
}