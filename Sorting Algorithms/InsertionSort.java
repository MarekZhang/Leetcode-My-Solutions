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
