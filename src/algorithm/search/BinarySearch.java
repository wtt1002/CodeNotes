package algorithm.search;

/**
 * Package: algorithm.search
 * Description： 二分查找
 * Author: TingTing W
 * Date: Created in 2018/7/22 22:14
 */
public class BinarySearch {
    /**
     *
     * @param array 待检索数组
     * @param target 检索目标数
     * @return 检索到的目标数的位置
     */
    public int binarySearch(int[] array, int target){
        if (array == null ||array.length == 0){
            return -1;
        }
        int start = 0;

        int end = array.length - 1;
        int mid;
        // 用 start+1 < end 来控制循环，不容易出错
        while (start + 1 < end){
            // 注意mid 的写法
            mid = start + (end - start)/2;
            if (array[mid] == target){
                return mid;
            }else if (target < array[mid]){
                end = mid;
            }else {
                start = mid;
            }
        }
        if (array[start] == target){
            return start;
        }
        if (array[end] == target){
            return end;
        }
        return -1;
    }
}
