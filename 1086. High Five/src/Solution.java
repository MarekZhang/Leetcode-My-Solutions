/**
 * 1086. High Five
Easy

291

60

Add to List

Share
Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.

Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The average score is calculated using integer division.

 

Example 1:

Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
Output: [[1,87],[2,88]]
Explanation: 
The average of the student with id = 1 is 87.
The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
 

Note:

1 <= items.length <= 1000
items[i].length == 2
The IDs of the students is between 1 to 1000
The score of the students is between 1 to 100
For each student, there are at least 5 scores
 */

class Solution {
  public int[][] highFive(int[][] items) {
    //each id has a pritority queue records one's all scores
    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    for(int i = 0; i < items.length; i++){
      int id = items[i][0];
      if(!map.containsKey(id)){
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> n2 - n1);
        map.put(id, queue);
      }
      map.get(id).offer(items[i][1]);
    }
    Set<Integer> keys = map.keySet();
    int[][] res = new int[keys.size()][2];
    int idx = 0;
    for(int key : keys){
      PriorityQueue<Integer> queue = map.get(key);
      int sum = 0;
      for(int i = 0; i < 5; i++){
        sum += queue.poll();
      }
      res[idx][0] = key;
      res[idx][1] = sum / 5;
      idx++;
    }

    return res;
  }

  public static void main(String[] args) {
    int[][] items = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
    int[][] ints = new Solution().highFive(items);

    System.out.println(Arrays.deepToString(ints));
  }
}