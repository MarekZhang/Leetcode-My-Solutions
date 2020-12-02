## Description
// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();

## Solution
- 对于当前的结点，它的index为n，将其作为最终result的概率是1/n; 其它结点作为最终res的概率需要 * (n-1)/n
- 遍历到第一个node,它作为res的概率是1/1；遍历到第二个结点，它作为res的概率是1/2, 同时node1作为最终res的概率是1 * (1 - 1/2) = 1/2; 遍历到第三个结点，它作为res的概率是1/3; node2作为res的概率是(1/2 * 2/3) = 1/3; node1作为res的概率是(1/2 * 2/3) = 1/3...

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
