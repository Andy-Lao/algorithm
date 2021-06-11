package sort;

public class QuickSort {
    //挖坑法
    public static void quickSort(int[] inputArray, int start, int end){
        //如start等于end，不做任何操作并返回
        if (start < end) {
            int pivot = inputArray[start];
            int index = start, left = start, right = end;
            //left指针与right指针未重合
            while (left < right) {
                //right指针元素大于基准元素，左移
                while (left < right && inputArray[right] > pivot){
                    right -= 1;
                }
                //right指针元素小于等于基准元素，填入坑中
                if (inputArray[right] <= pivot) {
                    inputArray[index] = inputArray[right];
                    index = right;
                }
                //left指针小于等于基准元素，右移
                while (left < right && inputArray[left] <= pivot){
                    left += 1;
                }
                //left指针元素大于基准元素，填入坑中
                if (inputArray[left] > pivot) {
                    inputArray[index] = inputArray[left];
                    index = left;
                }
            }
            //left指针与right指针重合后，将基准元素填回坑中
            inputArray[index] = pivot;
            //对数组在pivot左半部分和右半部分分别invoke quickSort
            quickSort(inputArray, start, index - 1);
            quickSort(inputArray, index + 1, end);
        }
    }

    //交换指针法
    public static void quickSortSwap(int[] inputArray, int start, int end){
        if (start < end) {
            //设置基准元素以及left right指针
            int pivot = inputArray[start];
            int left = start, right = end;
            //left指针与right指针未重合
            while(left < right) {
                //right指针元素大于基准时左移
                while(left < right && inputArray[right] > pivot){
                    right -= 1;
                }
                //left指针元素小于等于基准时右移
                while (left < right && inputArray[left] <= pivot){
                    left += 1;
                }
                //交换left指针元素和right指针元素
                if(inputArray[right] <= pivot && inputArray[left] > pivot) {
                    int temp = inputArray[right];
                    inputArray[right] = inputArray[left];
                    inputArray[left] = temp;
                }
            }
            //交换left指针right指针重合元素和基准元素
            int temp = inputArray[left];
            inputArray[left] = pivot;
            inputArray[start] = temp;
            //对数组在pivot左半部分和右半部分分别invoke quickSort
            quickSortSwap(inputArray, start, left - 1);
            quickSortSwap(inputArray, left + 1, end);
        }
    }
}
