# 382. Linked List Random Node

![382%20Linked%20List%20Random%20Node%202fc178ea91794967957d281afcc06319/Screenshot_2020-12-10_at_19.48.47.png](382%20Linked%20List%20Random%20Node%202fc178ea91794967957d281afcc06319/Screenshot_2020-12-10_at_19.48.47.png)

### Solution

- 同algorithm 4th中quick sort shuffling的思想，在不获取数组总长度的情况下就能够equally likely select element
- 随着i值的增加，每一个元素被选为最终结果的概率等于上一轮它被选中的概率 * 这一轮不被覆盖（random 值不等于当前轮的i值的概率). 比如第二轮选中arr[0]作为最终结果的概率为上一轮的概率p = 1 * 这一轮不被覆盖的概率也就是不random值≠ 1, $p = 1 * (1 - \frac{1}{2}) = \frac{1}{2}$. 第三轮arr[0]和arr[1]被选为最终结果的概率都等于它们上一轮被选中的概率*这一轮不被覆盖的概率$p = \frac{1}{2} * (1 - \frac{1}{3}) = \frac{1}{3}$

![382%20Linked%20List%20Random%20Node%202fc178ea91794967957d281afcc06319/Screenshot_2020-12-10_at_19.59.25.png](382%20Linked%20List%20Random%20Node%202fc178ea91794967957d281afcc06319/Screenshot_2020-12-10_at_19.59.25.png)

- 由此可得在不知道Linked List的长度的前提下，可以equally likely 选中每一个元素

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode node;
    public Solution(ListNode head) {
        node = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random rand = new Random();
        ListNode start = node;
        int res = 0;
        int i = 1;
        while(start != null){
            if(rand.nextInt(i) + 1 == i) res = start.val;
            start = start.next;
            i++;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
```