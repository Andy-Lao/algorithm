package sort;

public class MergeSort {
    public static void mergeSort(int[] inputArray){
        //数组如为null或长度为1，直接返回
        if(inputArray==null || inputArray.length<2){
            return;
        }
        //首次调用Process
        process(inputArray, 0, inputArray.length-1);
    }

    public static void process(int[] inputArray, int left, int right){
        //如子数组长度为1，返回
        if(left == right){
            return;
        }
        //避免因left/right过大而内存溢出
        int mid = left + (right - left)/2;
        //分别对左半部分和右半部分process
        process(inputArray, left, mid);
        process(inputArray, mid + 1, right);
        //有序合并左半部分和右半部分
        merge(inputArray,left,mid,right);
    }

    public static void merge(int[] inputArray, int left, int mid, int right){
        //创建一个临时数组来存放有序排列
        int[] temp = new int[right - left + 1];
        //创建三个指针，p1指向左半部分的开始，p2指向右半部分的开始，ind为临时数组的指针
        int p1 = left;
        int p2 = mid + 1;
        int ind = 0;

        // 用p1在左半部分迭代，p2在右半部分迭代
        // 将p1和p2中较小的放入临时数组temp，同时右移相应指针及ind指针
        while(p1 <= mid && p2 <= right){
            //temp[ind++] = inputArray[p1]>inputArray[p2] ? inputArray[p2++]:inputArray[p1++]; 一行方法
            if(inputArray[p1] > inputArray[p2]){
                temp[ind] = inputArray[p2];
                ind += 1;
                p2 += 1;
            } else {
                temp[ind] = inputArray[p1];
                ind += 1;
                p1 += 1;
            }
        }

        //一半数组完成后，将另一半数组的剩余的数放入临时数组
        while(p1 <= mid){
            temp[ind] = inputArray[p1];
            ind += 1;
            p1 += 1;
        }
        while(p2 <= right){
            temp[ind] = inputArray[p2];
            ind += 1;
            p2 += 1;
        }

        //将临时数组复制回原数组
        for(int j = 0; j < temp.length; j++){
            inputArray[left + j] = temp[j];
        }
    }

}
