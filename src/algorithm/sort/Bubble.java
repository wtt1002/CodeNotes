package algorithm.sort;

/**
 * Package: algorithm.sort
 * Description： 冒泡排序
 * Author: TingTing W
 * Date: Created in 2018/7/15 11:14
 *
 * 创建测试的快捷键：shift+ctrl+t
 */
public class Bubble {
    public void bubbleSort(int [] array)
    {
        if (array == null || array.length == 0) {
            return;
        }
        int temp;
        int length = array.length;
        for (int i = 0; i < length; i++){
            for (int j = length - 1; j > i; j--){
                if (array[j] < array[j - 1]){
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }

        for (int num : array) {
            System.out.println(num);
        }
    }
}
