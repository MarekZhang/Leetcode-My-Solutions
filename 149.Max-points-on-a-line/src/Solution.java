/**149. Max Points on a Line
Hard

797

1858

Add to List

Share
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:

Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4
Example 2:

Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature. 
*/
import java.util.*;

class Solution{
    public static int maxPoints(int[][] points) {
        
        if(points.length <= 1)
            return points.length;

        int maxPoints = 0;

        for(int i = 0; i < points.length; i++){
            int samePoints = 1; //add points[i] itself
            Map<String, Integer> map = new HashMap<String, Integer>();

            for(int j = 0; j < points.length; j++){
                if(j == i)
                    continue;
                if(points[i][0] == points[j][0] && points[i][1] == points[j][1])
                    samePoints ++;
                else{
                    String incline = getIncline(points[i], points[j]);
                    int count = map.getOrDefault(incline, 0); // points[i] counts for one point
                    map.put(incline, count + 1);
                }
            }

            //all the points are the same point, in that case the map is empty
            if(map.keySet().isEmpty())
                return samePoints;

            for(String str: map.keySet()){
                int tempt = map.get(str) + samePoints;
                maxPoints = tempt > maxPoints ? tempt : maxPoints;
            }
        }
        return maxPoints;

    }

    private static String getIncline(int[] i, int[] j){
        int x = i[0] - j[0];
        int y = i[1] - j[1];
        
        if(x == 0)
            return "0,1";
        
        if(y == 0)
            return "1,0";
        
        int gcdnum = gcd(Math.abs(x), Math.abs(y));
        x /= gcdnum;
        y /= gcdnum;

        if( x < 0){
            x = - x;
            y = - y;
        }

        return x + "," + y;
        
    }
    
    //greatest common divisor(gcd) 最大公约数
    private static int gcd(int m, int n){
        if(n > m){
            int tempt = m;
            m = n;
            n = tempt;
        }

        if( m % n == 0)
            return n;
        
        return gcd(n, m % n);
            
    }

    public static void main(String[] args){
        System.out.println(gcd(144, 156));
        int [][] points = {{0,0}, {0,0}};
        System.out.println(maxPoints(points));

    }

}