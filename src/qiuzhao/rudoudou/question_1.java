package qiuzhao.rudoudou;

import java.util.Scanner;

/**
 * Package: qiuzhao.rudoudou
 * Description： 第一题
 * Author: TingTing W
 * Date: Created in 2018/8/18 21:12
 */
public class question_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int min = 100000;
        int total = 0;
        for (int i = 0; i < num; i++){
            int temp = scanner.nextInt();
            if (temp < min){
                min = temp;
            }
            total += temp;
        }
        System.out.println(total - min);
    }
}
