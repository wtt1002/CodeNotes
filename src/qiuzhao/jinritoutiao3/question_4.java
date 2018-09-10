package qiuzhao.jinritoutiao3;

import java.util.Scanner;

/**
 * Package: qiuzhao.jinritoutiao3
 * Description： 第四条
 * Author: TingTing W
 * Date: Created in 2018/9/9 9:33
 */
public class question_4 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int array[] = new int[n];
        int i = 0;
        while (i < n) {
            array[i++] = scanner.nextInt();
        }
        int res = getUTF8(array, array.length);
        System.out.println(res);
    }

    private static int getUTF8(int[] array, int len) {
        if(array==null || len == 0) return 0;
        for(int i=0 ; i < len; i++) {
            if(array[i]>255) return 0;
            int byteIndex = 0;
            if((array[i] & 128) == 0) {
                byteIndex = 1;
            } else if((array[i] & 224) == 192) {
                byteIndex = 2;
            } else if((array[i] & 240) == 224) {
                byteIndex = 3;
            } else if((array[i] & 248) == 240) {
                byteIndex = 4;
            } else {
                return 0;
            }
            for(int j=1;j<byteIndex;j++) {
                if(i + j >= len) return 0;
                if((array[i+j] & 192) != 128) return 0;
            }
            i = i + byteIndex - 1;
        }
        return 1;
    }
}