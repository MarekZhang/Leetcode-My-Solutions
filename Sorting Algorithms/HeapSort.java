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