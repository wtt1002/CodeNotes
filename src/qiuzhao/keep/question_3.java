package qiuzhao.keep;

import java.util.Scanner;

/**
 * Package: qiuzhao.keep
 * Description： 第三题
 * Author: TingTing W
 * Date: Created in 2018/9/12 16:23
 */

/**
 * 输入两个正整数n，d (1 <= d <= 1000),把n堪称2字符串，求n的所有子串中能被d整除的子串的个数
 */
public class question_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int d = scanner.nextInt();
        char[] chars = str.toCharArray();
        int[] array = char2Int(chars);
        int[][] dp = new int[array.length + 1][d];
        for (int i = 1; i <= array.length; i++){
            for (int j = 0; j < d; j++){
                int temp = 0;
                for (int k = 0; k < d; k++){
                    if ((k*10 + array[i - 1])%d == j){
                        temp += dp[i - 1][k];
                    }
                }
                if (array[i - 1] % d == j)temp++;
                dp[i][j] = dp[i -1][j] + temp;
            }
        }
        System.out.println(dp[str.length()][0]);
    }
    private static int[] char2Int(char[] chars){
        int[] array = new int[chars.length];
        for (int i = 0; i < chars.length; i++){
            array[i] = chars[i] - '0';
        }
        return array;
    }
}
