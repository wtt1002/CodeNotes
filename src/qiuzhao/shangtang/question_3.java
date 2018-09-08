package qiuzhao.shangtang;

import java.util.Scanner;

/**
 * Package: qiuzhao.shangtang
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/9/7 0007$ 下午 6:55$
 */
public class question_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] grade = new int[n+1];
        int[] next = new int[n+1];
        int[][] flag = new int[n+1][n+1];
        for (int i = 1; i <= n; i++){
            grade[i] = scanner.nextInt();
            next[i] = scanner.nextInt();
        }
        if (n == 1){
            System.out.println(grade[1]);
            return;
        }
        int max = -1000000;
        for (int i = 1; i <= n; i++){
            int start = i;
            int end = next[i];
            int temp = 0;
            while (flag[i][start] == 0){
                temp += grade[start];
                flag[i][start] = 1;
                start = end;
                end = next[start];
                if (max < temp){
                    max = temp;
                }
            }
        }
        System.out.println(max);
    }
}
