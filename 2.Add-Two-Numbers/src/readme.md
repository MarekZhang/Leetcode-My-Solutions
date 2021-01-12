# 2. Add Two Numbers

![2%20Add%20Two%20Numbers%2088acf8e0ac7e40468e20bce4e6cdc3a1/Untitled.png](2%20Add%20Two%20Numbers%2088acf8e0ac7e40468e20bce4e6cdc3a1/Untitled.png)

### Solution

- simply use a recursive method to connect the sum of each bit together

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
		//time O(N) || space O(N)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addDigits(l1, l2, 0);
    }

    private ListNode addDigits(ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null){
            if(carry == 0) return null;
            return new ListNode(carry);
        }
        int val1, val2;
        ListNode nex1, nex2;
        if(l1 == null){
            val1 = 0;
            nex1 = null;
        }else{
            val1 = l1.val;
            nex1 = l1.next;
        }

        if(l2 == null){
            val2 = 0;
            nex2 = null;
        }else{
            val2 = l2.val;
            nex2 = l2.next;
        }

        int sum = val1 + val2 + carry;
        int bit = sum > 9 ? 1 : 0;
        ListNode cur = new ListNode(sum % 10);
        cur.next = addDigits(nex1, nex2, bit);

        return cur;
    }
}
```