## Key point
- 涉及到指针和取值一定要多考虑是否为null的情况
```java
    class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
            
        ListNode cur = head;
        ListNode nex = head.next;

        while(nex!=null){
            while(nex != null && nex.val == cur.val)//nex 可能为null
                nex = nex.next;
            cur.next = nex;
            cur = nex;
        }

        return head;
    }
}
```