import java.util.*;

public class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == k)
            return nums;
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue((ele1, ele2) -> map.get(ele1) - map.get(ele2));
        for(int ele : map.keySet()){
            if(queue.size()==k)
                queue.poll();
            queue.add(ele);
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++)
            res[i] = queue.poll();

        return res;
    }
}