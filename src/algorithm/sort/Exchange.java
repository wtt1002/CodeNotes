package algorithm.sort;

/**
 * Package: algorithm.sort
 * Description： 交换排序
 * Author: TingTing W
 * Date: Created in 2018/7/15 14:16
 */
public class Exchange {

    public void ExchangeSort(int [] array){
        if (array == null || array.length <= 0){
            return;
        }

        int temp;
        for (int i = 0; i < array.length - 1; i++){
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[i]){
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }

        for (int num : array) {
            System.out.println(num);
        }
    }
}
