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
```java
import java.util.Arrays;

public class MergeSort {
  public void sort(int[] arr){
    mergeSort(arr, 0, arr.length - 1);
  }

  private void mergeSort(int[] arr, int start, int end){
    if(start >= end)
        return;

    int mid = start + (end - start) / 2;
    mergeSort(arr, start, mid);
    mergeSort(arr, mid + 1, end);
    if(arr[mid] > arr[mid + 1])
      merge(arr, start, mid, end);
  }

  private void merge(int[] arr, int start, int mid, int end){
    int[] aux = Arrays.copyOfRange(arr, start, end + 1);
    int l = start;
    int r = mid + 1;
    int i = start;
    while(i <= end){
      if(l > mid){
        arr[i] = aux[r - start];
        r++;
      }else if(r > end){
        arr[i] = aux[l - start];
        l++;
      }else if(aux[l - start] < aux[r - start]){
        arr[i] = aux[l - start];
        l++;
      }else{
        arr[i] = aux[r - start];
        r++;
      }

      i++;
    }
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
  public void sort(int[] arr){

    for(int i = 0; i < arr.length; i++){
      int j = i;
      for(; j > 0 && arr[j] < arr[j - 1]; j--){
        arr[j] = arr[j - 1];
      }
      swap(arr, j, i);
    }
  }

  private void swap(int[] arr, int x, int y){
    int tempt = arr[x];
    arr[x] = arr[y];
    arr[y] = tempt;
  }

  public static void main(String[] args) {
    int[] arr = SortTest.generate(10000);
    new InsertionSort().sort(arr);
    System.out.println(SortTest.isSorted(arr));
  }
}
```