package qiuzhao.huawei;

import java.util.Scanner;

public class question_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String valueStr = scanner.nextLine();
        int[] values = lineToInts(valueStr);
        String weightStr = scanner.nextLine();
        int[] weights = lineToInts(weightStr);
        int maxWeight = scanner.nextInt();
        int[] dp = new int[10000];
        int ans = 0;
        for (int i = 0; i < values.length; i++){
            for (int k = maxWeight; k >= 0; k--){
                if (k - weights[i] >= 0){
                    dp[k] = getMax(dp[k], dp[k-weights[i]]+values[i]);
                    ans = getMax(dp[k], ans);
                }
            }
        }
        System.out.println(ans);

    }

    private static int getMax(int a, int b) {
        return a > b ? a:b;
    }

    private static int[] lineToInts(String str) {
        if (str == null || str.length() == 0)return null;
        String[] strs = str.split(",");
        int[] array = new int[strs.length];
        for (int i = 0; i < array.length; i++){
            array[i] = strToInt(strs[i]);
        }
        return array;
    }

    private static int strToInt(String str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++){
            num = num * 10 + str.charAt(i) - '0';
        }
        return num;
    }
}
