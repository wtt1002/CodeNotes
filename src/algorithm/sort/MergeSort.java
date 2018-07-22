package algorithm.sort;

/**
 * Package: algorithm.sort
 * Description： 二路归并排序
 * Author: TingTing W
 * Date: Created in 2018/7/22 16:06
 */


public class MergeSort {
    /**
     *
     * @param array 待排序数组
     * @param temp 辅助数组
     * @param start 开始下标
     * @param end 结束下标
     */
    public void sort(int[] array, int[] temp, int start, int end){
        if (start >= end)return;
        int mid = (start + end)/2;
        // 解决左边子问题
        sort(array, temp, start, mid);
        // 解决右边子问题
        sort(array, temp, mid + 1, end);
        // 合并两个子问题
        merge(array, temp, start, end, mid);

    }

    /**
     *
     * @param array 待排序数组
     * @param temp 辅助数组
     * @param start 开始下标
     * @param end 结束下标
     * @param mid 中点下标（start + end）/2
     */
    public void merge(int[] array, int[] temp, int start, int end, int mid) {
        int i,j,k;
        i = start;
        j = mid + 1;
        k = start;

        while (i <= mid && j <= end){
            if (array[i] < array[j]){
                temp[k++] = array[i++];
            }else {
                temp[k++] = array[j++];
            }
        }

        // 若左子数组还有元素
        while (i <= mid){
            temp[k++] = array[i++];
        }
        // 若右子数组还有元素
        while (j <= end){
            temp[k++] = array[j++];
        }

        //将辅助数组的元素一一对应copy到原数组
        for (int index = start; index <= end; index++){
            array[index] = temp[index];
        }
    }
}
