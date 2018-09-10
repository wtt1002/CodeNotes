package qiuzhao.jinritoutiao3;

import java.util.Scanner;

/**
 * Package: qiuzhao.jinritoutiao3
 * Description： 第五题
 * Author: TingTing W
 * Date: Created in 2018/9/9 9:33
 */
public class question_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0; i < m; i++){
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();

        }
        int count = 0;
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i < m; i++){
            dp[a[i]][b[i]] = 1;
            for (int j = 1; j <= n;j++){
                if (dp[b[i]][j] == 1 && dp[a[i]][j] == 0){
                    dp[a[i]][j] = 1;
                }
            }
            for(int k = 1; k <= n; ++ k){
                if((dp[k][a[i]] == 1)){
                    for(int t = 1; t <= n; ++ t){
                        if(dp[a[i]][t] == 1)
                            dp[k][t] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++){
            int flag = 1;
            for (int j = 1; j <= n; j++){
                if (i != j && dp[j][i] == 0){
                    flag = 0;
                }
            }
            if (flag == 1){
                count++;
            }
        }
        System.out.println(count);
    }
}
