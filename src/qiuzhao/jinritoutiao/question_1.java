package qiuzhao.jinritoutiao;

import java.util.ArrayList;
import java.util.Scanner;

public class question_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        int raw = strToIntArray(info)[0];
        int col = strToIntArray(info)[1];
        int[][] matrix = new int[raw][col];
        for (int i = 0; i < raw; i++){
            matrix[i] = strToIntArray(scanner.nextLine());
        }
//        for (int i = 0; i < raw; i++){
//            for (int j = 0; j < col; j++){
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
        int[][] dp = new int[raw][col];
        ArrayList<Integer> length = new ArrayList<>();
        for (int i = 0; i < raw; i++){
            length.add(0);
        }
        length.add(0);
        dp[0][0] = 0;
        int index = 0;
//        for (int i = 1; i < raw; i++){
//            if (matrix[i][0] == 1){
//                if (dp[i - 1][0] != 0){
//                    dp[i][0] = dp[i - 1][0];
//
//                }else {
//                    dp[i][0] = index;
//                    length.add(0);
//                    index++;
//                }
//                int temp = length.get(dp[i][0]);
//                length.set(dp[i][0], temp + 1);
//            }
//        }
//        for (int j = 1; j < col; j++){
//            if (matrix[0][j] == 1){
//                if (dp[0][j - 1] != 0){
//                    dp[0][j] = dp[0][j - 1];
//                }else {
//                    dp[0][j] = index;
//                    length.add(0);
//                    index++;
//                }
//                int temp = length.get(dp[0][j]);
//                length.set(dp[0][j], temp + 1);
//            }
//        }
        for (int i = 0; i < raw; i++){
            for (int j = 0; j < col; j++){
                if (matrix[i][j] == 1){

                    if (i - 1 >= 0 && j - 1 >= 0 && dp[i - 1][j - 1] != 0) {
                        System.out.println("左上有i:" + i + " j:" + j);
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (i - 1 >= 0 && dp[i - 1][j] != 0) {
                        System.out.println("上有i:" + i + " j:" + j);
                        dp[i][j] = dp[i - 1][j];
                    } else if (j - 1 >= 0 && dp[i][j - 1] != 0) {
                        System.out.println("左有i:" + i + " j:" + j);
                        dp[i][j] = dp[i][j - 1];
                    } else if (i - 1 >= 0 && j + 1 < col && dp[i - 1][j + 1] != 0) {
                        System.out.println("右上有i:" + i + " j:" + j);
                        dp[i][j] = dp[i - 1][j + 1];
                    } else {
                        System.out.println("新建i:" + i + " j:" + j);
                        dp[i][j] = index;
                        length.add(0);
                        index++;

                    }
                    int temp = length.get(dp[i][j]);
                    length.set(dp[i][j], temp + 1);
                }

            }
        }
        System.out.println("arlistlen:" + length.size() + "   "+ index);
        for (int k = 0; k < length.size(); k++){
            if (length.get(k) != 0){
                System.out.println(length.get(k));
            }

        }

    }
    public static int[] strToIntArray(String str){
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
