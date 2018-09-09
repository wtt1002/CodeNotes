package qiuzhao.jinritoutiao3;

import java.util.Scanner;
/**
 * Package: qiuzhao.jinritoutiao3
 * Description： 第五题
 * Author: TingTing W
 * Date: Created in 2018/9/9 11:49
 */
public class question_5_new {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] pair = new int[m][2];
        int[][] graph = new int[n][n];
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph[x - 1][y - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            graph[i][i] = 1;
        }
        int cnt = 0;
        int[][] temp = new int[n][n];
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i][j] = graph[i][j] | (graph[i][k] & graph[k][j]);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = temp[i][j];
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                if (graph[i][j] == 1) {
                    ++tmp;
                }
            }
            if (tmp == n) {
                ++cnt;
            }
        }
        System.out.println(cnt);
    }

}