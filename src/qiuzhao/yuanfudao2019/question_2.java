package qiuzhao.yuanfudao2019;

import java.util.Scanner;

/**
 * Package: qiuzhao.yuanfudao2019
 * Description: 第二题
 * Author: TingTing W
 * Date: Created in 2018/8/26 6:48
 */
public class question_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        String str = scanner.next();
        int k = (len - 1)/3;
        int temp = k;
        int index = 0;
        for (int i = 0; i < k; i++){
            for (int j = 0; j < i; j++){
                System.out.print(" ");
            }
            System.out.print(str.charAt(index));
            index++;
            for (int m = 0; temp >= 1 && m < 2*temp - 1; m++){
                System.out.print(" ");
            }
            temp--;
            System.out.print(str.charAt(index));
            index++;
            System.out.println();

        }
        for (int i = 0; i <= k; i++){
            for (int j = 0; j < k; j++){
                System.out.print(" ");
            }
            System.out.println(str.charAt(index));
            index++;
        }
    }
}
