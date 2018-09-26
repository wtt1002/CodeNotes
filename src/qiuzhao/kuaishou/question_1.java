package qiuzhao.kuaishou;

import java.util.Scanner;

/**
 * Package: qiuzhao.kuaishou
 * Description： 第一题（过88%）
 * Author: TingTing W
 * Date: Created in 2018/9/10 0010$ 下午 5:54$
 */
public class question_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num <= 0){
            System.out.println(0);
            return;
        }
        int[] array = new int[num];
        for (int i = 0; i < array.length; i++){
            array[i] = scanner.nextInt();
        }
        int[] totalLeft = new int[num];
        totalLeft[0] = array[0];
        for (int i = 1; i < num; i++){
            totalLeft[i] = array[i] + totalLeft[i - 1];
        }
        int[] totalRight = new int[num];
        totalRight[num - 1] = array[num - 1];
        for (int i = num - 2; i >= 0; i--){
            totalRight[i] = array[i] + totalRight[i + 1];
        }

        int l = 0;
        int r = num - 1;
        int max = 0;
        while (l < r){
            if (totalLeft[l] < totalRight[r]){
                l++;
            }else if (totalLeft[l] > totalRight[r]){
                r--;
            }else {
                if (max < totalLeft[l]){
                    max = totalLeft[l];
                }
                l++;
                r--;
            }
        }
        System.out.println(max);
    }
}
