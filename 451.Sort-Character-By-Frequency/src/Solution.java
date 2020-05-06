// Given a string, sort it in decreasing order based on the frequency of characters.

// Example 1:

// Input:
// "tree"

// Output:
// "eert"

// Explanation:
// 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
// Example 2:

// Input:
// "cccaaa"

// Output:
// "cccaaa"

// Explanation:
// Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
// Note that "cacaca" is incorrect, as the same characters must be together.
// Example 3:

// Input:
// "Aabb"

// Output:
// "bbAa"

// Explanation:
// "bbaA" is also a valid answer, but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.
import java.util.*;

public class Solution{
    public static String frequencySort(String s) {
        //store character - count pair in the dictionary
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }
        Set<Character> chSet = map.keySet();

        //reverse the key value pair
        //防止相同频次的character相互覆盖，将相同次数character拼接到一起
        Map<Integer, String> reverseMap = new HashMap<>();
        for(Character ch: chSet) {
            String str = ch.toString();
            int freq = map.get(ch);
            reverseMap.put(freq, reverseMap.containsKey(freq) ? reverseMap.get(freq) + str : str);
        }

        Set<Integer> countSet = reverseMap.keySet();

        //sort the keys (counts of character)
        List<Integer> countList = new ArrayList<>(countSet);
        Collections.sort(countList, Collections.reverseOrder());

        StringBuilder finalStr = new StringBuilder();

        //concat the string 
        for(int i = 0 ; i < countList.size() ; i++){
            String value = reverseMap.get(countList.get(i));
            for(int j = 0; j < value.length(); j++)
                finalStr.append(new String(new char[countList.get(i)]).replace('\u0000', value.charAt(j)));
        }

        return finalStr.toString();
    }
    
    // public static String frequencySort(String s) {
    //     String result = "";
    //     // step 1
    //     int[] counter = new int[65535];
    //     for (int i = 0; i < s.length(); i++) counter[s.charAt(i)] += 1;
    //     // step 2
    //     HashMap<Integer, String> map = new HashMap();
    //     for (int i = 0; i < counter.length; i++) {
    //         int times = counter[i];
    //         if (times == 0) continue;
    //         Character alp = (char) i;
    //         String sub = alp.toString();
    //         map.put(times, map.containsKey(times) ? map.get(times) + sub : sub);
    //     }
    //     // step 3
    //     Set<Integer> keyset = map.keySet();
    //     ArrayList<Integer> keyList = new ArrayList<>(keyset);
    //     Collections.sort(keyList, Collections.reverseOrder());
    //     // step 4
    //     for (int i = 0; i < keyList.size(); i++) {
    //         int times = keyList.get(i);
    //         String alps = map.get(times);
    //         //由于相同次数到char全部存储到了一起，所有1必然是最后一个key value pair
    //         if (times == 1) {
    //             result += alps;
    //             break;
    //         }
    //         for (int j = 0; j < alps.length(); j++) {
    //             Character torepeat = alps.charAt(j);
    //             //初始化一个对应个数到char数组 全部为‘\u0000', 再将其替换为对应到字符
    //             result += new String(new char[times]).replace("\0", torepeat.toString());
    //         }
    //     }
    //     return result;
    // }

    public static void main(String args[]){
        String s = "tree";
        System.out.println(frequencySort(s));
        
    }
}