package qiuzhao.jinritoutiao3;

import java.util.Scanner;

/**
 * Package: qiuzhao.jinritoutiao3
 * Description： 第二题
 * Author: TingTing W
 * Date: Created in 2018/9/9 11:16
 */
public class question_2_new {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int[][] parts = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                parts[i][j] = scanner.nextInt();

            }
        }
        int count = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (parts[i][j] == 1){
                    bfsCore(parts, i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }


    private static void bfsCore(int[][] parts, int i, int j){
        if (i < 0 || i > parts.length - 1 || j < 0 || j > parts[0].length - 1 || parts[i][j] == 0){
            return;
        }
        parts[i][j] = 0;
        bfsCore(parts,i - 1, j);
        bfsCore(parts, i + 1, j);
        bfsCore(parts, i, j - 1);
        bfsCore(parts, i, j + 1);
        return;

    }

}
