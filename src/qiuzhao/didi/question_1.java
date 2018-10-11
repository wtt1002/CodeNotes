package qiuzhao.didi;

import java.util.Scanner;

/**
 * Package: qiuzhao.didi
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/10/10 18:49
 */
public class question_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] v = new int[n + 1];
        for (int i = 0; i < n; i++){
            v[i] = scanner.nextInt();
        }
        v[n] = 1000000000;
        int min1;
        int min2;
        for(int i = 0; i < m; ++ i){
            min1 = n;
            min2 = n;
            for(int j = 0; j < n; ++ j){
                if(v[j] != 0 && v[j] < v[min1]){
                    min1 = j;

                }
            }
            for(int k = min1+1; k < n; ++ k){
                if(v[k] != 0){
                    min2 = k;
                    break;
                }
            }
            for(int k = min1 - 1; k >= 0; -- k){
                if(v[k] != 0){
                    if(v[min2] > v[k])
                        min2 = k;
                    break;
                }
            }
            v[min1] += v[min2];
            v[min2] = 0;
        }
        int min = 1000000000;
        for(int i = 0; i < n; ++ i){
            if(v[i] != 0 && min > v[i])
                min = v[i];
        }
        System.out.println(min);

    }
}
