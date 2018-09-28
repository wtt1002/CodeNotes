package algorithm.dp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Package: algorithm.dp
 * Description： 01背包
 * Author: TingTing W
 * Date: Created in 2018/9/12 21:32
 */
public class package01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalV = scanner.nextInt();
        int itemSum = scanner.nextInt();
        int[][] items = new int[itemSum + 1][2];
        for (int i = 1; i < itemSum + 1; i++){
            //体积
            items[i][0] = scanner.nextInt();
            //价值
            items[i][1] = scanner.nextInt();
        }
        int[][] dp = new int[itemSum + 1][totalV + 1];
        for (int i = 1; i <= itemSum; i++){
            for (int j = 0; j <= totalV; j++){
                if (j >= items[i][0]){
                    dp[i][j] = max(dp[i - 1][j - items[i][0]] + items[i][1],dp[i - 1][j]);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < totalV + 1; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        ArrayList<Integer> choose = new ArrayList<>();
        for (int i = 1; i < dp.length; i++){
            for (int j = 0; j < totalV + 1; j++){
                if (dp[i][j] != dp[i - 1][j]){
                    choose.add(i);
                    break;
                }
            }
        }
        for (Integer i :
                choose) {
            System.out.print(i + " ");
        }
    }
    private static int max(int a, int b){
        return a > b ? a : b;
    }
}
