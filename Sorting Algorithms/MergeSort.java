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
