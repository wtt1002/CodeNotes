package qiuzhao.jinritoutiao3;

import java.util.Scanner;

/**
 * Package: qiuzhao.jinritoutiao3
 * Description： 第二题
 * Author: TingTing W
 * Date: Created in 2018/9/9 9:32
 */
public class question_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int[][] parts = new int[n][n];
        int output = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                parts[i][j] = scanner.nextInt();

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int flag = 0;
                if (parts[i][j] == 1) {
                    output++;
                    //if (((i - 1) >= 0 && parts[i - 1][j] == 1) || ((j - 1) >= 0 && parts[i][j - 1] == 1)){
                    //output--;
                    if (i >= 1) {
                        if (parts[i - 1][j] == 1)
                            flag = 1;
                    }
                    if (j >= 1) {
                        if (parts[i][j - 1] == 1)
                            flag = 1;
                    }
                    if (flag == 1)
                        output--;
                }
            }
        }
        System.out.println(output);
    }
}

