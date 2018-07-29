package algorithm.dp;

import java.util.ArrayList;

/**
 * Package: algorithm.dp
 * Description： 给定一个矩阵m，从左上角开始每次只能向右走或者向下走，最后达到右下角的位置，路径中所有数字累加起来就是路径和，返回所有路径的最小路径和
 * Author: TingTing W
 * Date: Created in 2018/7/29 15:31
 */
public class MinPath {
    public static void main(String[] args) {
        int[][] array = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1},{8, 8, 4, 0}};
        int[][] dp = new int[4][4];
        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                dp[i][j] = 1000000;
            }
        }

        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                if (dp[i][j] == 1000000) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = array[i][j];
                    } else if (i == 0 && j != 0) {
                        dp[i][j] = array[i][j] + dp[i][j - 1];
                    } else if (j == 0 && i != 0) {
                        dp[i][j] = array[i][j] + dp[i - 1][j];
                    } else {
                        dp[i][j] = array[i][j] + getMin(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0,j = 0; i < dp.length && j < dp[0].length;){
//
//        }

    }

    private static int getMin(int a, int b) {
        return a < b ? a : b;
    }
}
