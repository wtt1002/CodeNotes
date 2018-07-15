package algorithm.sort;

/**
 * Package: algorithm.sort
 * Description： 堆排序
 * Author: TingTing W
 * Date: Created in 2018/7/15 15:19
 */
public class Heap {

    /**
     * heapsort,初始化堆，并将每一次形成的堆的堆顶元素放到数组尾部
     * @param array 待排序数组
     */
    public void heapSort(int[] array){
        // 边界处理
        if (array == null || array.length <= 0){
            return;
        }
        // 构建初始堆
        for (int start = array.length /2 - 1; start >= 0; start--){
            adjustHeap(array, start, array.length - 1);
        }

        for (int k = array.length - 1; k >= 0; k--){
            int tmp = array[k];
            array[k] = array[0];
            array[0] = tmp;
            adjustHeap(array, 0, k - 1);
        }
    }

    /**
     * 堆调整
     * @param array 待排序数组
     * @param start 待排序开始下标
     * @param end 待排序结束下标
     */
    public void adjustHeap(int[] array, int start, int end){
        // 最开始的start的值
        int temp = array[start];
        //用j记录start左孩子的下标： j = 2 * start + 1
        for (int j = 2 * start + 1; j <= end; j = j * 2 + 1){
            // 找出左右孩子中最大的
            if (j + 1 <= end && array[j + 1] > array[j]){
                j++;
            }
            // temp > array[j] 说明符合要求，不需要调整
            if (temp > array[j]){
                break;
            }
            // 不符合要求，需要调整，更新array[start]，再更新start
            array[start] = array[j];
            start = j;
        }
        // 将最开始的start的值（暂存在temp），放到合适的位置
        array[start] = temp;

    }
}
