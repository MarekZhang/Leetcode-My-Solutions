/**
 * 347. Top K Frequent Elements
Medium

3051

209

Add to List

Share
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.
 * 
 */
import java.util.*;
import javafx.util.*;


class Solution {
    // Pair contains 1.the element and 2.the Frequency of the element 
    private class Pair implements Comparable<Pair>{
        int ele;
        int freq;
        public Pair(int ele, int freq){
            this.ele = ele;
            this.freq = freq;
        }
        @Override
        public int compareTo(Pair pair2){
            return this.freq - pair2.freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        int[] res = new int[k];
        //the key is element, the value is frequency
        Map<Integer, Integer> map = new HashMap<>();
        for(int a: nums){
            if(map.containsKey(a))
                map.put(a, map.get(a) + 1);
            else
                map.put(a, 1);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        for(Integer i: map.keySet()){
            if(queue.size()!=k)
                queue.add(new Pair(i, map.get(i)));
            else{
                if(queue.peek().freq < map.get(i)){
                    queue.poll();
                    queue.add(new Pair(i, map.get(i)));
                }
            }
        }
        
        for(int i = 0; i < k; i++){
            res[i] = queue.poll().ele;
        }

        return res;
    }

    public static void main(String[] args) {
        int k = 1;
        int[] arr = {1};
        int[] res = new Solution().topKFrequent(arr, k);

        for(int i: res){
            System.out.print(i + " ");
        }

    }
}