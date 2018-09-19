package qiuzhao.tengxun;

import java.util.Scanner;

/**
 * Package: qiuzhao.tengxun
 * Description： 第一题
 * Author: TingTing W
 * Date: Created in 2018/9/16 0016$ 上午 9:56$
 */
public class question_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = i + 1;
        }
        for (int index = n + 1; index < 1000000; index++){
            int[] b = new int[index - n];
            for (int i = 0; i < index - n; i++){
                b[i] = i + n + 1;
            }
            if (getMoreSmallMul(b,index - n) % getMoreSmallMul(a,n) == 0){
                System.out.println(index);
                break;
            }
        }
    }
    // 求两个数的最大公约数
    private static int getBigEle(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getBigEle(b, a % b);
    }
    // 求两个数的最小公倍数
    private static int getSmallMul(int a, int b) {
        return (a * b) / getBigEle(a, b);
    }
    // 求多个数的最小公倍数
    private static int getMoreSmallMul(int num[], int n) {
        if (n == 1)
            return num[n - 1];
        return getSmallMul(num[n - 1], getMoreSmallMul(num, n - 1));
    }

}
