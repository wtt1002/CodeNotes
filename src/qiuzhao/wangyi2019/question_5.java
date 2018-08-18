package qiuzhao.wangyi2019;

import java.util.Scanner;

/**
 * Package: qiuzhao.wangyi2019
 * Description： 网易2019第五题
 * Author: TingTing W
 * Date: Created in 2018/8/18 11:02
 */
public class question_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int[] outs = new int[6];
        outs[0] = a + b + c;
        outs[1] = a * b + c;
        outs[2] = a + b * c;
        outs[3] = a * b * c;
        outs[1] = a * (b + c);
        outs[2] = (a + b) * c;
        int max = outs[0];
        for (int i = 1; i < 6; i++){
            if (outs[i] > max){
                max = outs[i];
            }
        }
        System.out.println(max);

    }
}
