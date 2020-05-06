
public class Solution2 {
    public static boolean isIsomorphic(String s, String t){

        if(s.length() != t.length())
            return false;

        char[] sArr = new char[256];
        boolean[] used = new boolean[256];

        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(sArr[sChar] == '\u0000' && !used[tChar]){
                sArr[sChar] = tChar;
                used[tChar] = true;
            }else if(sArr[sChar] == '\u0000' && used[tChar])
                return false;
            else{
                if(sArr[sChar] != tChar)
                    return false;
            }
        }
        return true;
    }
    

    public static void main(String args[]){
        String t = "paper";
        String s = "title";

        System.out.println(isIsomorphic(s, t));
    }
}