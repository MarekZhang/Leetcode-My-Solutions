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
  