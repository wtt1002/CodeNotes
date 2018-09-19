package qiuzhao.tengxun;

import java.util.Scanner;

/**
 * Package: qiuzhao.tengxun
 * Description： 第一题
 * Author: TingTing W
 * Date: Created in 2018/9/16 0016$ 上午 11:52$
 */
public class question_1_new {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = i + 1;
        }
        for (int index = n + 1; index < 1000000; index++){
            int[] b = new int[index - n];
            long  mul = 1;
            for (int i = 0; i < index - n; i++){
                b[i] = i + n + 1;
                mul *= i + n + 1;
            }
            if (mul % getMoreSmallMul(a,n) == 0){
                System.out.println(index);
                break;
            }
        }
        //System.out.println(getMoreSmallMul(a, n));
    }

    private static int getBigEle(int a, int b) {// 求两个数的最大公约数
        if (b == 0) {
            return a;
        }
        return getBigEle(b, a % b);
    }

    private static int getSmallMul(int a, int b) {// 求两个数的最小公倍数
        return (a * b) / getBigEle(a, b);
    }

    private static int getMoreSmallMul(int num[], int n) {// 求多个数的最小公倍数
        if (n == 1)
            return num[n - 1];
        return getSmallMul(num[n - 1], getMoreSmallMul(num, n - 1));
    }

}