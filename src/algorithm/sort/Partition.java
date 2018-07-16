package algorithm.sort;

import java.util.Random;

/**
 * Package: algorithm.sort
 * Description： 快排
 * Author: TingTing W
 * Date: Created in 2018/7/15 17:02
 */
public class Partition {

    /**
     * 头部快排
     * @param array 待排序数组
     * @param start 开始下标
     * @param end 结束下标
     */
    public void partition(int[] array, int start, int end){

        if (start >= end)return;
        int flag = array[start];
        int preStart = start;
        int preEnd = end;
        while (start < end){
            while (start < end && array[end] > flag){
                end--;
            }
            if (start < end){
                array[start] = array[end];
            }

            while (start < end && array[start] < flag){
                start++;
            }
            if (start < end){
                array[end] = array[start];
            }
        }
        array[start] = flag;
        partition(array, preStart,start - 1);
        partition(array, start + 1, preEnd);

    }

    /**
     *  尾部快排
     * @param array 待排序数组
     * @param start 开始下标
     * @param end 结束下标
     */
    public void partition_last(int[] array, int start, int end){
        if (start >= end)return;
        int preStart = start;
        int preEnd = end;
        int flag = array[end];
        while (start < end) {
            while (start < end && array[start] < flag) {
                start++;
            }
            if (start < end) {
                array[end] = array[start];
            }
            while (start < end && array[end] > flag) {
                end--;
            }
            if (start < end) {
                array[start] = array[end];
            }
        }
        array[start] = flag;
        partition_last(array, preStart, start - 1);
        partition_last(array, start + 1, preEnd);
    }


    public int partition_base (int[] array, int start, int end){
        int flag = array[start];
        while (start < end){
            while (start < end && array[end] > flag){
                end--;
            }
            if (start < end){
                array[start] = array[end];
            }

            while (start < end && array[start] < flag){
                start++;
            }
            if (start < end){
                array[end] = array[start];
            }
        }
        array[start] = flag;
        return start;
    }

    public void partition_random(int[] array, int start, int end){
        if (start >= end)return;
        int pos = new Random().nextInt(end - start + 1) + start;
        System.out.println("随机数：" + pos);
        int temp = array[0];
        array[0] = array[pos];
        array[pos] = temp;
        int loc = partition_base(array, start, end);

        partition_random(array, start, loc - 1);
        partition_random(array, loc + 1, end);

    }
}
