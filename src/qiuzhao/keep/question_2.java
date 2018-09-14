package qiuzhao.keep;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Package: qiuzhao.keep
 * Description： 第二题-01背包
 * Author: TingTing W
 * Date: Created in 2018/9/12 16:45
 */
public class question_2 {
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
//        for (int i = 0; i < dp.length; i++){
//            for (int j = 0; j < totalV + 1; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        ArrayList<Integer> choose = new ArrayList<>();
        int[] mark = new int[itemSum + 1];
        for (int i = 1; i < dp.length; i++){
            for (int j = 0; j < totalV + 1; j++){
                if (dp[i][j] != dp[i - 1][j]){
                    choose.add(i);
                    mark[i] = 1;
                    break;
                }
            }
        }
        for (int i = 1; i < mark.length; i++){
            System.out.println(mark[i]);
        }
    }
    private static int max(int a, int b){
        return a > b ? a : b;
    }
}
