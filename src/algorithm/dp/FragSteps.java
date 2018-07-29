package algorithm.dp;

/**
 * Package: algorithm.dp
 * Description： 案例一：有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。
 * Author: TingTing W
 * Date: Created in 2018/7/29 14:34
 */
public class FragSteps {


    public static void main(String[] args) {
        int[] dp = new int[9 + 1];
        System.out.println(countMethods(dp, 4));

    }
    public static int countMethods(int[] dp, int n){
        if (n == 1 || n == 2){
            return n;
        }
        if (dp[n - 1] == 0){
            dp[n - 1] = countMethods(dp, n - 1);
        }
        if (dp[n - 2] == 0){
            dp[n - 2] = countMethods(dp, n - 2);
        }
        return dp[n - 1] + dp[n - 2];
    }
}
