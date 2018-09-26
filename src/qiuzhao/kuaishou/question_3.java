package qiuzhao.kuaishou;

import java.util.Scanner;

/**
 * Package: qiuzhao.kuaishou
 * Description： 第三题（过42）
 * Author: TingTing W
 * Date: Created in 2018/9/10 0010$ 下午 5:55$
 */
public class question_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num <= 0){
            System.out.println(0);
            return;
        }
        if (num == 1){
            scanner.nextInt();
            scanner.nextInt();
            System.out.println(1);
            return;
        }
        int[][] blocks = new int[num][2];
        int widthMax = 0;
        int lengthMax = 0;
        for (int i = 0; i < num; i++){
            blocks[i][0] = scanner.nextInt();
            blocks[i][1] = scanner.nextInt();
            if (blocks[i][0] > widthMax){
                widthMax = blocks[i][0];
            }
            if (blocks[i][1] > lengthMax){
                lengthMax = blocks[i][1];
            }
        }
        int[][] dp = new int[widthMax + 1][lengthMax + 1];
        for (int i = 0; i < num; i++){
            dp[blocks[i][0]][blocks[i][1]]++;
        }
        for (int i = 1; i < widthMax + 1; i++){
            for (int j = 1; j < lengthMax + 1; j++){
                dp[i][j] = dp[i][j] + Math.max(dp[i - 1][j] , dp[i][j - 1]);
            }
        }
        System.out.println(dp[widthMax][lengthMax]);
    }
    public static int max(int a, int b, int c){
        if (a > b){
            return a > c ? a : c;
        }else {
            return b > c ? b : c;
        }
    }
}
