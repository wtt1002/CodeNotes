package qiuzhao.jinritoutiao2;

import java.util.Scanner;

/**
 * 未完成
 */
public class question_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleSum = scanner.nextInt();
        int[][] mark = new int[peopleSum + 1][peopleSum + 1];
        for (int i = 1; i <= peopleSum; i++){
            int peopleNum = scanner.nextInt();
            while (peopleNum != 0){
                mark[i][peopleNum] = 1;
                mark[peopleNum][i] = 1;
                peopleNum = scanner.nextInt();
            }
        }
        for (int i = 0; i < peopleSum; i++){
            for (int j = 0; j < peopleSum; j++){
                System.out.print(mark[i][j] + " ");
            }
            System.out.println();
        }
    }
    /**
     * 10
     0
     5 3 0
     8 4 0
     9 0
     9 0
     3 0
     0
     7 9 0
     0
     9 7 0
     */
}
