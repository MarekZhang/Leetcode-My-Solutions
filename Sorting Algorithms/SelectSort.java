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
  