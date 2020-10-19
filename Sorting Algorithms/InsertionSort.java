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
}
  