package algorithm.dp;

import java.util.Scanner;

/**
 * Package: algorithm.dp
 * Description： 找到所有的匹配括号的数量，但是不是最大匹配数量的子串
 * Author: TingTing W
 * Date: Created in 2018/9/23 9:50
 */
public class MatchKuohao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] mark = new int[s.length() + 1];
        int[][] dp = new int[s.length() + 1][2];
        char[] symbol = s.toCharArray();
        int totalMax = 0;
        for (int i = 1; i < symbol.length + 1; i++){
            if (symbol[i - 1] == '('){
                mark[i] = mark[i - 1] - 1;
                dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]);

            }else {
                if (mark[i - 1] < 0){
                    dp[i][1] = max(dp[i - 1][0], dp[i - 1][1]) + 2;
                    mark[i] = mark[i - 1] + 1;
                }else {
                    mark[i] = 0;
                }
            }
            if (max(dp[i][0], dp[i][1]) > totalMax){
                totalMax = max(dp[i][0], dp[i][1]);
            }
        }

        int[] mark2 = new int[s.length() + 1];
        int[][] dp2 = new int[s.length() + 1][2];
        int totalMax2 = 0;
        for (int i = symbol.length; i >= 1; i--){
            if (symbol[i - 1] == ')'){
                mark[i] = mark[i + 1] - 1;
                dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]);

            }else {
                if (mark[i - 1] < 0){
                    dp[i][1] = max(dp[i - 1][0], dp[i - 1][1]) + 2;
                    mark[i] = mark[i - 1] + 1;
                }else {
                    mark[i] = 0;
                }
            }
            if (max(dp[i][0], dp[i][1]) > totalMax){
                totalMax = max(dp[i][0], dp[i][1]);
            }
        }


        System.out.println(totalMax);
    }
    private static int max(int a, int b){
        return a > b ? a : b;
    }
}
