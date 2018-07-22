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

    /**
     * 快排基本方法
     * @param array 待排序数组
     * @param start 开始下标
     * @param end 结束下标
     * @return 已排序位置
     */
    public int partition_base (int[] array, int start, int end){
        System.out.println(start + "..." + end);
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

    /**
     * 随机快排入口
     * @param array 待排序数组
     * @param start 开始下标
     * @param end 结束下标
     */
    public void partition_random(int[] array, int start, int end){
        // 边界处理
        if (start >= end)return;
        // 随机位置
        int pos = new Random().nextInt(end - start + 1) + start;
        // 随机化待排序数组
        int temp = array[start];
        array[start] = array[pos];
        array[pos] = temp;
        // 获取已排号位置的下标
        int loc = partition_base(array, start, end);
        // 递归调用
        partition_random(array, start, loc - 1);
        partition_random(array, loc + 1, end);

    }
}
