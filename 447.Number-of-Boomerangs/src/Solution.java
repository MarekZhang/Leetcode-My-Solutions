/**447. Number of Boomerangs
Easy

375

629

Add to List

Share
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:

Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
*/

import java.util.*;
//store all distance to one specific points
public class Solution{
    public static int numberOfBoomerangs(int[][] points) {

        int result = 0;

        for(int i = 0; i < points.length; i++){

            Map<Integer, Integer> map = new HashMap<>();

            for(int j = 0; j < points.length; j++){
                if(j == i)
                    continue;
                int dist = calculateDist(points[i], points[j]);
                int count = map.getOrDefault(dist, 0);
                map.put(dist, count + 1);
            }

            // ArrayList distList = new ArrayList(map.keySet());

            for(Integer in: map.keySet()){
                int distCount = map.get(in);
                if( distCount >= 2)
                    result += (distCount * (distCount - 1));
            }
        }

        return result;
    }

    private static int calculateDist(int[] i, int[]j ){
        return (i[0] - j[0]) * (i[0] - j[0]) + (i[1] - j[1]) * (i[1] - j[1]);
    }
}