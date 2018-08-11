package qiuzhao.wangyi;

import java.util.Scanner;

public class question_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] interest = new int[n];
        int[] wake = new int[n];
        for (int i = 0; i < n; i++){
            interest[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++){
            wake[i] = scanner.nextInt();
        }
        int output = wakeUp(interest, wake, k);
        for(int i = 0; i < interest.length; ++ i){
            if(wake[i] == 1)
                output += interest[i];
        }
        System.out.println(output);
    }
    public static int wakeUp(int[] interest, int[] wake, int k){
        int max = 0;
        for(int i = 0; i < interest.length - k + 1; ++ i){
            int temp = 0;
            for(int j = i; j < k+i; ++ j){
                if(wake[j] == 0)
                    temp += interest[j];
            }
            if (temp > max)
                max = temp;
        }
        return max;
    }
}
