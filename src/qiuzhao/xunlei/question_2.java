package qiuzhao.xunlei;

import java.util.Scanner;

/**
 * Package: qiuzhao.xunlei
 * Description： 第二题
 * Author: TingTing W
 * Date: Created in 2018/9/12 0011$ 下午 6:48$
 */
public class question_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = 0;
        for(int i = 0; i <= N ; ++ i){
            for(int j = i + 1; j <= N; ++ j){
                for(int k = j + 1; k <= N; ++ k){
                    if(i * i + j * j == k * k && judge(i, j, k))
                        count += 1;
                }
            }
        }
        System.out.println(count);
    }
    private static boolean judge(int a, int b, int c){
        for(int i = 2; i < a; i++){
            if(a % i == 0 && b % i == 0 && c % i == 0)
                return false;
        }
        return true;
    }
}
