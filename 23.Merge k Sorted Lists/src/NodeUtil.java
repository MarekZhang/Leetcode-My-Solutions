public class NodeUtil {

    public static ListNode createList(int[] arr, int n){
        if(n == 0)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for(int i = 1; i < n; i++){
           cur.next = new ListNode(arr[i]);
           cur = cur.next;
        }
        return head;
    }

    public static void printList(ListNode node){
        ListNode cur = node;
        while(cur != null){
            System.out.print(cur.val + "-->");
            cur = cur.next;
        }
        System.out.println("NULL");
    }

}