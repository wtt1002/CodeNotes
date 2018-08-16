package qiuzhao.wangyi2019;

import java.util.Scanner;

public class question_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int col = scanner.nextInt();
        int sum = scanner.nextInt();
        int[] blocks = new int[col + 1];
        for (int i = 0; i < sum; i++){
            int n = scanner.nextInt();
            blocks[n]++;
        }
        int min = sum;
        for (int i = 1; i <= col; i++){
            if (blocks[i] < min){
                min = blocks[i];
            }
        }
        System.out.println(min);
    }
}
