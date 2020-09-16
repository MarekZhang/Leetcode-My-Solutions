/** 
 * 155. Min Stack
Easy

3813

360

Add to List

Share
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
*/


class MinStack {
    LinkedList<Integer> stack;
    LinkedList<Integer> minValue;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minValue = new LinkedList<>();
    }
    
    // time O(1) | space O(1)
    public void push(int x) {
        if(stack.size() == 0){
            minValue.addLast(x);
        }else{
            int tempt = minValue.getLast();
            minValue.addLast(tempt < x ? tempt : x);
        }
        stack.addLast(x);
    }
    
    //time O(1) | space O(1)
    public void pop() {
        stack.removeLast();
        minValue.removeLast();
    }
    //time O(1) | space O(1)
    public int top() {
            
        return stack.getLast();
    }
    //time O(1) | space O(1)
    public int getMin() {
        
        return minValue.getLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */