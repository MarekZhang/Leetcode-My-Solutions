import java.util.*;

public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();

        queue1.addFirst(root);
        queue2.addFirst(root);

        while(!queue1.isEmpty() && !queue2.isEmpty()){
            TreeNode tempt1 = queue1.removeFirst();
            TreeNode tempt2 = queue2.removeFirst();
            
            if(tempt1 == null && tempt2 == null)
                continue;
            if(tempt1==null && tempt2!=null || tempt1!=null && tempt2==null)
                return false;
            if(tempt1.val != tempt2.val)
                return false;

            queue1.addLast(tempt1.left);
            queue1.addLast(tempt1.right);

            queue2.addLast(tempt2.right);
            queue2.addLast(tempt2.left);
        }

        return queue1.isEmpty() && queue2.isEmpty();
    }
}