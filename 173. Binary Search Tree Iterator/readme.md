# 173. Binary Search Tree Iterator

![173%20Binary%20Search%20Tree%20Iterator%20f3fbf5efac994e1eac138385e5af5a56/Screenshot_2020-12-09_at_21.05.07.png](173%20Binary%20Search%20Tree%20Iterator%20f3fbf5efac994e1eac138385e5af5a56/Screenshot_2020-12-09_at_21.05.07.png)

![173%20Binary%20Search%20Tree%20Iterator%20f3fbf5efac994e1eac138385e5af5a56/Screenshot_2020-12-09_at_21.07.01.png](173%20Binary%20Search%20Tree%20Iterator%20f3fbf5efac994e1eac138385e5af5a56/Screenshot_2020-12-09_at_21.07.01.png)

### Solution

- follow up 中要求使用O(h)的空间其实就隐含告诉我们存储某一方向的分支
    - 利用stack，iteratively从root开始将左结点全部存入栈中
    - 每次有元素出栈的时候将当前元素的right node iteratively存入所有左结点
- 虽然调用next()时会调用pushLeft,多次存入新元素到数组中，但由算法时间复杂度很重要的amortized analysis(均摊分析)，可得每个元素最多只入栈和出栈一次，所以调用N次next()最多总共进行了2N次pop和push。那么每次调用next实际的时间复杂度就是$O(2N / N) = O(2) ~ O(1)$

```java
class BSTIterator{
  LinkedList<TreeNode> stack = new LinkedList<>();
  //time complexity of next() on average is O(1) | space complexity O(h)
  public BSTIterator(TreeNode root){
    pushLeft(root);
  }

  public int next(){
    //next function is guaranteed not to be invoked on null
    TreeNode node = stack.pop();
    pushLeft(node.right);

    return node.val;
  }

  public boolean hasNext(){
    return !stack.isEmpty();
  }

  private void pushLeft(TreeNode node){
    while(node != null){
      stack.push(node);
      node = node.left;
    }
  }
}
```