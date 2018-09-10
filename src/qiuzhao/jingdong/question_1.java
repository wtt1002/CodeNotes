package qiuzhao.jingdong;

import java.util.Scanner;

/**
 * Package: qiuzhao.jingdong
 * Description： 第一题
 * Author: TingTing W
 * Date: Created in 2018/9/9 18:34
 */
public class question_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++){
            int nodeSum = scanner.nextInt();
            int edgeSum = scanner.nextInt();
            int[] starts = new int[edgeSum];
            int[] ends = new int[edgeSum];
            for (int j = 0; j < edgeSum; j ++){
                starts[j] = scanner.nextInt();
                ends[j] = scanner.nextInt();
            }
            if(ifComplete(nodeSum, edgeSum, starts, ends) == 1){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }

        }
    }
    private static int ifComplete(int n, int m, int[] starts, int[] ends){
        int[] flag = new int[n + 1];
        for (int i = 1; i <= n; i++){
            if (flag[i] == 0){
                int[] temp = new int[n + 1];
                for (int j = 0; j < m; j++){
                    if (starts[j] == i){
                        temp[ends[j]] = 1;
                    }else if (ends[j] == i){
                        temp[starts[j]] = 1;
                    }
                }
                for (int k = 1; k <= n; k++){
                    if (i != k && temp[k] == 0){
                        if (flag[k] == 0){
                            flag[k] = 1;
                        }else {
                            return 0;
                        }
                    }
                }
            }
        }
        return 1;
    }

}
