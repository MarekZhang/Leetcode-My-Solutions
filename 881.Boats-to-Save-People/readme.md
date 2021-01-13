# 881. Boats to Save People

![881%20Boats%20to%20Save%20People%209560133304bb461ebab8022c0ad03a07/Untitled.png](881%20Boats%20to%20Save%20People%209560133304bb461ebab8022c0ad03a07/Untitled.png)

### Solution

- greedy algorithm: we first sort the weight of people in natural order. What we want to do is trying the best to utilize the space of boat as much as possible, so for each iteration, we try to put people with the highest weight was a people with the lightest weight into the same boat.

```java
class Solution {
		//time O(NlogN) | space O(1)
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int p1 = 0, p2 = people.length - 1, count = 0;
        while(p1 <= p2){
            if(people[p1] + people[p2] <= limit){
                p1++;
                p2--;
            }else{
                p2--;
            }
            count++;
        }
        
        return count;
    }
}
```