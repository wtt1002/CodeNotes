package qiuzhao.wangyi;

import java.util.Scanner;

public class question_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        if (k <= 0 || k > n * m + 2){
            System.out.println(-1);
            return;
        }else {
            int addStep = (k) % m;
            int baseStep = (k) / m;
            System.out.println(k + "  ..." + baseStep + " " + m);
            int[] mark = new int[n + m];
            for (int i = 0; i < n; i++){
                mark[i] = 0;
            }
            for (int j = n; j < n + m; j++){
                mark[j] = 1;
            }
            for (int t = n; t < n + m; t++){
                if (addStep > 0){
                    System.out.println(baseStep);
                    mark[t - baseStep] = 1;
                    mark[t] = 0;
                    addStep--;
                }
            }
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < n + m; i++){
                if (mark[i] == 0){
                    buffer.append('a');
                }else {
                    buffer.append('z');
                }
            }
            System.out.println(buffer.toString());
        }
    }
}
