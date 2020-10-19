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
