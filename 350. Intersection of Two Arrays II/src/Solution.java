class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            int count = map.getOrDefault(nums1[i], 0);
            map.put(nums1[i], count + 1);
        }
        
        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);    
            }
        }
        
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        
        return res;
    }
}