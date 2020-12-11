## Sorting Algorithms

### 2 Ways Quick Sort

- 快排有多种方式，单路;双路;三路，一般来说双路快排就能够得到一个很好的性能
    - 双路快排核心函数为partition，对于 arr[start, end] 区间将arr分为两部分[start + 1, p]的值全部小于等于arr[start]; [p + 1, end]的值大于等于arr[start]
    - 防止快排退化为O(N^2)就要合理优化partition函数，使得partition的两部分元素数量均衡。为应对近乎有序的数组，在每次partition之前进行一次随机交换
```java
import java.util.Arrays;
import java.util.Random;

class QuickSort{
  public void sort(int[] arr){
    if(arr.length == 0)
      return;

    quickSort(arr, 0, arr.length - 1);
  }

  public void quickSort(int[] arr, int start, int end){
    if(start >= end)
      return;
    int p = partition(arr, start, end);
    quickSort(arr, start, p - 1);
    quickSort(arr, p + 1, end);
  }
  //return the swap pos
  private int partition(int[] arr, int start, int end){

    swap(arr, start, start + new Random().nextInt(end - start + 1));
    //arr[start + 1, i] <= arr[start] || arr[j, end] >= arr[start]
    int i = start + 1;
    int j = end;
    while(true){
      while(i <= end && arr[i] < arr[start]) i++;
      while(j - 1 > start && arr[j] > arr[start]) j--;
      if(i > j)// i == j可能停在 arr[j] > arr[start]的位置
          break;
      swap(arr, i++, j--);
    }
    swap(arr, start, j);

    return j;
  }

  private void swap(int[] arr, int x, int y){
    if(x == y)
      return;
    int tempt = arr[x];
    arr[x] = arr[y];
    arr[y] = tempt;
  }
}
```

### Merge Sort
- Merge Sort 的核心思想是至顶向下将整个数组打散，然后再bottom to top将数组合并
- 一个小优化是在merge之前首先判断是否需要merge。因为mid的左边以及右边已经有序了，如果arr[mid]<= arr[mid + 1]那么无需merge数组就已经有序了
- Top to Bottom
```java
public class MergeSort {
  private Integer[] aux;
  public void sort(Integer arr[]){
    aux = new Integer[arr.length];
    int N = arr.length;
    sort(arr, 0, N - 1);
  }

  private void sort(Integer arr[], int lo, int hi){
    if(lo >= hi) return;
    int mid = lo + (hi - lo) / 2;
    sort(arr, lo, mid);
    sort(arr, mid + 1, hi);
    merge(arr, lo, mid, hi);
  }

  private void merge(Integer arr[], int lo, int mid, int hi){
    int i = lo, j = mid + 1;
    for(int k = lo; k <= hi; k++)
      aux[k] = arr[k];
    int k = lo;
    while(k <= hi){
      if(i > mid) arr[k]= aux[j++];
      else if(j > hi) arr[k]= aux[i++];
      else if(aux[i] > aux[j]) arr[k]= aux[j++];
      else arr[k] = aux[i++];
      k++;
    }
  }

  public static void main(String[] args) {
    int LEN = 1000000;
    Integer arr[] = ArrayUtil.randomArray(LEN);
    long l = System.currentTimeMillis();
    new MergeSort().sort(arr);
    System.out.println("running: " + (System.currentTimeMillis() - l));
    System.out.println(ArrayUtil.isSorted(arr));
  }
}
```

- Bottom Up
```java
public class MergeSortBT {
  private Integer aux[];

  public void sort(Integer arr[]){
    int N = arr.length;
    aux = new Integer[N];
    sort(arr, 0, N - 1);
  }

  private void sort(Integer arr[], int lo, int hi){
    if(lo >= hi) return;
    int N = arr.length;
    for(int sz = 1; sz < N; sz+=sz)
      for(int i = 0; i < N - sz; i = i + 2 * sz)
        merge(arr, i, i + sz - 1, Math.min(i + 2 * sz - 1, N - 1));
  }

  private void merge(Integer arr[], int lo, int mid, int hi){
    int i = lo, j = mid + 1;
    for(int k = lo; k <= hi; k++)
      aux[k] = arr[k];
    int k = lo;
    while(k <= hi){
      if(i > mid) arr[k] = aux[j++];
      else if(j > hi) arr[k] = aux[i++];
      else if(aux[i] > aux[j]) arr[k] = aux[j++];
      else arr[k] = aux[i];
      k++;
    }
  }
  public static void main(String[] args) {
    int LEN = 1000000;
    Integer arr[] = ArrayUtil.randomArray(LEN);
    long l = System.currentTimeMillis();
    new MergeSortBT().sort(arr);
    System.out.println("running: " + (System.currentTimeMillis() - l));
    System.out.println(ArrayUtil.isSorted(arr));
  }
}
```

### Heap Sort
- 构建Heap的两个核心function： siftDown(), siftUp()
- Heap Sort 只用到了siftDown()
    - 拿到一个无序数组首先要将其构造成一个最大堆，方法是从最后一个非叶子结点[(arr.length - 1 - 1) / 2]开始，进行siftDown操作，直到idx=0的位置做完了siftDown操作，就构建成了一个MaxHeap
    - 从idx = arr.length - 1开始，每次将数组[0]位置元素与[idx]位置元素交换，这样idx位置元素已经在正确堆位置了,然后对[0]进行siftDown操作
    - 直到idx = 0，数组排序完成
```java
class HeapSort{
  public void sort(int[] nums){
    int N = nums.length;
    //从最后一个非叶子结点开始siftDown来构建MaxHeap
    for(int i = (N - 1 - 1) / 2; i >= 0; i--){
      siftDown(nums, i, N);
    }
    //HeapSort: 1.nums[0]与nums[i]交换，对nums[0]进行siftDown操作
    for(int i = N - 1; i > 0; i--){
      swap(nums, 0, i);
      siftDown(nums, 0, i);//i为最后一个元素的位置此时已经在最终位置上
    }

    return;
  }

  //siftDown 需要知道交换元素对index以及堆的大小
  private void siftDown(int[] nums, int idx, int size){
    //左子结点没有越界的判断条件
    while(idx * 2 + 1 < size){
      int j = idx * 2 + 1;
      if(j + 1 < size && nums[j + 1] > nums[j])
        j++;
      if(nums[idx] > nums[j])//idx元素已经在正确的位置上
        break;
      swap(nums, idx, j);
      idx = j;
    }
  }

  private void swap(int[] nums, int x, int y){
    int tempt = nums[x];
    nums[x] = nums[y];
    nums[y] = tempt;
  }
}
```

### Bubble Sort
- 循环可能会提前终止，如果没有发生swap
```java
public class BubbleSort {
    public void sort(int[] arr){
      int n = arr.length;
  
      for(int i = 0; i < n; i++) {
        boolean swapped = false;
        for (int j = 0; j < n - i - 1; j++) {
          if(arr[j] > arr[j + 1]) {
            swap(arr, j, j + 1);
            swapped = true;
          }
        }
        if(!swapped)
          break;
      }
    }
  
    private void swap(int[] arr, int x, int y){
      int tempt = arr[x];
      arr[x] = arr[y];
      arr[y] = tempt;
    }
}
```

### Selection Sort
- 每一次遍历找到最小的值与当前head element进行交换
```java
public class SelectSort {
    public void sort(int[] arr){
      for(int i = 0; i < arr.length; i++){
        int minIdx = i;
        for(int j = i + 1; j < arr.length; j++){
          if(arr[j] < arr[minIdx])
            minIdx = j;
        }
        swap(arr, i, minIdx);
      }
    }
  
    private void swap (int[] arr, int x, int y){
      int tempt = arr[x];
      arr[x] = arr[y];
      arr[y] = tempt;
    }
}
```

### Insertion Sort
- 插入排序避免频繁调用swap函数的一个trick是将数值不断向前一位复制移动
```java
public class InsertionSort {
  public void sort(Integer[] arr){

    for(int i = 0; i < arr.length; i++){
      int tempt = arr[i];
      int j = i;
      for(; j > 0 && arr[j - 1] > tempt;j--){
        arr[j] = arr[j - 1];
      }
      arr[j] = tempt;
    }
  }


  public static void main(String[] args) {
    Integer arr[] = new Integer[1000];
    Random rand = new Random();
    for (int i = 0; i < 1000; i++) {
      arr[i] = rand.nextInt(10000);
    }
    new InsertionSort().sort(arr);
    System.out.println(Arrays.deepToString(arr));
    boolean flag = true;
    for (int i = 1; i < 1000; i++) {
      if(arr[i] < arr[i - 1])
        flag = false;
    }
    System.out.println(flag);
  }
}
```

### Shell Sort
- shell sort的主要思想是对insertion sort的改良。insertion sort每次只交换一位，假设最小键值在数组最右侧，则需要N-1次交换才能将其移动至数组左端。而shell sort构造h-sort数组，随着h的减小，每次排序都能将sub array中较小元素向左端移动而较大元素向右端移动，这对最后h==1,也就是insertion sort的交换次数可以明显减少
```java
public class ShellSort {
  private static final int LEN = 1000000;
  public void sort(Integer arr[]) {
    int N = arr.length;
    int h = 1;
    while(N / 3 > h) h = h * 3 + 1;
    while (h >= 1) {
      for (int i = h; i < N; i++) {
        int tempt = arr[i];
        int j = i;
        for (; j >= h && arr[j - h] > tempt; j -= h) {
          arr[j] = arr[j - h];
        }
        arr[j] = tempt;
      }
      h/=3;
    }
  }

  public static void main(String[] args) {
    Integer arr[] = new Integer[LEN];
    Random rand = new Random();
    long l = System.currentTimeMillis();
    for (int i = 0; i < LEN; i++) {
      arr[i] = rand.nextInt(LEN);
    }
    new ShellSort().sort(arr);
    System.out.println("running: " + (System.currentTimeMillis() - l));
  }
}
```

### Priority Queue
- priority 的优势是如果我们只想取最大的几个值，就不需要对这个数组进行排序，因为这样时间复杂度是NlogN, 空间复杂度是O(N),而如果我们有priority queue，可以维护一个size为M的数组，不停的向这个小数组中插入和删除值，这样时间复杂度是NlogM,空间复杂度是O(M)
- priority底层是complete(perfectly balanced, except for bottom level) binary tree
- 两个关键的方法siftDown和siftUp

```java
public class PriorityQueue {
  private Integer heap[];
  private int N = 0;
  public PriorityQueue(Integer arr[]){
    heap = new Integer[arr.length + 1];
    for(int num : arr){
      insert(num);
    }
  }

  public void insert(Integer key){
    if(N == heap.length - 1) return;
    heap[++N]= key;
    siftUp(N);
  }

  public int deleteMax(){
    int res = heap[1];
    swap(heap, 1, N--);
    heap[N + 1] = null;
    siftDown(1);
    return res;
  }

  public boolean isEmpty(){
    return N == 0;
  }

  public int size() {
    return N;
  }

  private void siftDown(int pos){
    while(pos * 2 <= N){
      int j = pos * 2;
      if(j + 1 <= N && heap[j+1] > heap[j]) j++;
      if(heap[pos] > heap[j]) break;
      swap(heap, pos, j);
      pos = j;
    }
  }

  private void siftUp(int pos){
    while(pos > 1){
      int parent = pos / 2;
      if(heap[parent] > heap[pos]) break;
      swap(heap, pos, parent);
      pos/=2;
    }
  }

  private void swap(Integer arr[], int i, int j){
    if(i == j) return;
    Integer tempt = arr[i];
    arr[i] = arr[j];
    arr[j] = tempt;
  }

  public static void main(String[] args) {
    final int LEN = 1000000;
    Integer arr[] = ArrayUtil.randomArray(LEN);
    PriorityQueue queue = new PriorityQueue(arr);
    Integer res[] = new Integer[LEN];
    for(int i = LEN - 1; i >= 0; i--)
      res[i] = queue.deleteMax();
    System.out.println(ArrayUtil.isSorted(res));
  }
}
```
