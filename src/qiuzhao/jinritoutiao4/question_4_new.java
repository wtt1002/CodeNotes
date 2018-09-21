package qiuzhao.jinritoutiao4;

import java.util.Scanner;

/**
 * Package: qiuzhao.jinritoutiao4
 * Description： 第四题（动态规划）
 * Author: TingTing W
 * Date: Created in 2018/9/20 0020$ 下午 8:41$
 */
public class question_4_new {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        long[][][][] array = new long[n + 1][m + 1][k + 1][3];
        array[0][0][1][2] = 1;
        array[0][1][0][1] = 1;
        array[1][0][0][0] = 1;

        for (int i = 0; i < n + 1; i++){
            for (int j = 0 ; j < m + 1; j++){
                for (int t = 0; t < k + 1; t++){
                    if (i > 0)
                        array[i][j][t][0] += array[i - 1][j][t][1] + array[i - 1][j][t][2];
                    if (j > 0)
                        array[i][j][t][1] += array[i][j - 1][t][0]  + array[i][j - 1][t][2];
                    if (t > 0)
                        array[i][j][t][2] += array[i][j][t - 1][0] + array[i][j][t - 1][1];

                }
            }
        }
        long count = 0;
        for (int i = 0; i < 3; i++){
            count += array[n][m][k][i];
        }
        System.out.println(count);
    }
}
