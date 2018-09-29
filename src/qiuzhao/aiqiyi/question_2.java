package qiuzhao.aiqiyi;

import java.util.Scanner;

/**
 * Package: qiuzhao.aiqiyi
 * Description： 第二题
 * Author: TingTing W
 * Date: Created in 2018/9/28 0028$ 下午 6:51$
 */
public class question_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num == 1){
            System.out.println(2);
        }else if (num == 2){
            System.out.println(3);
        }else {
            long a1 = 1;
            long a2 = 2;
            long a3 = 0;
            for (int i = 2; i < num; i++){
                a3 = a1 + a2 + 1;
                a1 = a2;
                a2 = a3;
            }
            System.out.println(a3 + 1);
        }
    }
}
