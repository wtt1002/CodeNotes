package qiuzhao.jinritoutiao;

import java.util.*;

public class question_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int[] arrayA = new int[num];
        int[] arrayB = new int[num];
        for (int i = 0; i < num; i++){
            arrayA[i] = scanner.nextInt();
        }
        for (int i = 0; i < num; i++){
            arrayB[i] = scanner.nextInt();
        }
        int count = 0;
        for (int i = 0; i < num; i++){
            int max = arrayA[i];
            int min = arrayB[i];
            for (int j = i; j < num; j++){
                if (arrayA[j] > max){
                    max = arrayA[j];
                }
                if (arrayB[j] < min){
                    min = arrayB[j];
                }
                if (max < min){
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
