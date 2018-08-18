package qiuzhao.wangyi2019;

import java.util.Scanner;

public class question_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] interest = new int[n];
        int[] wake = new int[n];
        int preMark = 0;
        for (int i = 0; i < n; i++){
            interest[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++){
            wake[i] = scanner.nextInt();
            preMark += interest[i] * wake[i];
        }


        int maxDiff = 0;
        for (int i = 0; i < n - k; i++){
            int j = i + k;
            if (wake[i] == 0){
                int temp = 0;
                for (int t = i; t < j; t++){
                    if (wake[t] == 0){
                        temp += interest[t];
                    }
                }
                if (temp > maxDiff){
                    maxDiff = temp;
                }

            }
        }
        int temp = 0;
        for (int t = n - k; t < n; t++){
            if (wake[t] == 0){
                temp += interest[t];
            }
        }
        if (temp > maxDiff){
            maxDiff = temp;
        }
        System.out.println(preMark + maxDiff);
    }
}
