import java.util.Arrays;

/**
 * you're given two arrays int[] w, int[] v which contain the weight and value of an item separately
 * you're also given an knapsack capacity C find the optimum solution which fit your knapsack with
 * the maximum value
 */

//recursion with auxiliary array (memorize search)
class KnapSack {
  private int[][] memo;

  //time O(n^2) n is the number of items || space O(n * m) m is the value of capacity
  public int knapSack(int[] v, int[] w, int capacity) {
    assert (v.length == w.length);
    int n = v.length;
    if (n == 0 || capacity <= 0)
      return 0;
    //find the bestValue with items fro [0...n-1];
    memo = new int[n][capacity + 1];
    for(int i = 0; i < n; i++){
      Arrays.fill(memo[i], -1);
    }

    return bestValue(v, w, capacity, n - 1);
  }

  private int bestValue(int[] v, int[] w, int capacity, int index) {
    //have no item to be selected || the knapsack has no extra space
    if (index < 0 || capacity <= 0)
      return 0;
    if (memo[index][capacity] != -1)
      return memo[index][capacity];

    //f(n, c) = max (f(n-1, c), v(n) + f(n-1, c-w(n)))
    int res = bestValue(v, w, capacity, index - 1);

    if (capacity >= w[index])
      res = Math.max(res, v[index] + bestValue(v, w, capacity - w[index], index - 1));

    memo[index][capacity] = res;

    return res;
  }

  public static void main(String[] args) {
    int[] w = {1,2,3};
    int[] v = {6,10,12};

    System.out.println(new KnapSack().knapSack(v,w,6));
  }

}