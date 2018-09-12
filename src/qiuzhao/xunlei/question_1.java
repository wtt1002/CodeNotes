package qiuzhao.xunlei;

import java.util.Scanner;

/**
 * Package: qiuzhao.xunlei
 * Description： 第一题
 * Author: TingTing W
 * Date: Created in 2018/9/12 0011$ 下午 6:46$
 */
public class question_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextByte();
        int[] array = new int[17];
        for (int i = 0; i < 17; i++){
            array[i] = A;
        }
        int sevenA = 7 * A;
        int index = 6;
        while (sevenA > 0){
            sevenA -= A;
            sevenA += B;
            array[index] = B;
            index--;
        }
        for (int i = 1; i <= 10; i++){
            int total = getSeven(array, i, i + 6);
            index = i + 6;
            while (total > 0){
                total -= A;
                total += B;
                array[index] = B;
                index--;
            }
        }
        int sum = 0;
        for (int i = 0; i < 17; i++){
            sum += array[i];
        }
        System.out.println(sum);
    }
    private static int getSeven(int[] array, int i, int j){
        int total = 0;
        for (int t = i; t <= j; t++){
            total += array[t];
        }
        return total;
    }
}
