package qiuzhao.pinduoduo;

import java.util.Scanner;

public class question_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int len = str.length()/4;
        char[][] array = new char[len + 1][len + 1];
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                array[i][j] = ' ';
            }
        }
        int index = 0;
        // 上
        for (int i = 0; i < len; i++){
            array[0][i] = str.charAt(index++);
        }
        // 右
        for (int j = 0; j < len; j++){
            array[j][len] = str.charAt(index++);
        }
        // 下
        for (int k = len; k > 0; k--){
            array[len][k] = str.charAt(index++);
        }
        // 左
        for (int l = len; l > 0; l--){
            array[l][0] = str.charAt(index++);
        }

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                System.out.print(array[i][j]);
            }
            if (i < array.length - 1){
                System.out.println();
            }
        }
    }


}
