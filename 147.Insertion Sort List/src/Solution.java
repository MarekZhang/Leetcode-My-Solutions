/**
 * 147. Insertion Sort List
Medium

580

567

Add to List

Share
Sort a linked list using insertion sort.


A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 

Algorithm of Insertion Sort:

Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
 */

 class Solution{
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead.next;

        while(pre.next!=null){
            ListNode pi = dummyHead;
            ListNode nex = pre.next.next;
            int val = pre.next.val;

            for(;pi!=pre ; pi=pi.next){
                if(pi.next.val > val){
                    ListNode swapNode = pre.next;
                    ListNode pj = pi.next;
                    pi.next = swapNode;
                    swapNode.next = pj;

                    pre.next = nex;
                    break;
                }
            }

            //pre之后的结点在正确的位置上
            if(pre == pi){ pre = pre.next;}
        }

        ListNode result = dummyHead.next;
        dummyHead = null;

        return result;
    }

    public static void main(String[] args){
        int arr[] = {-1,5,3,4,0};
        ListNode head = NodeUtil.createList(arr, arr.length);
        NodeUtil.printList(head);
        head = new Solution().insertionSortList(head);
        NodeUtil.printList(head);

    }
 }