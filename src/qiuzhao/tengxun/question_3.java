package qiuzhao.tengxun;

import java.util.Scanner;

/**
 * Package: qiuzhao.tengxun
 * Description： 第三题
 * Author: TingTing W
 * Date: Created in 2018/9/16 0016$ 上午 9:56$
 */
public class question_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0 ; i < n; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (isSatisfy(a, b, c)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }

        }
    }
    private static boolean isSatisfy(int a, int b, int c){
        a = a%b;
        for (int i = 1; i <= b; i++){
            if (i * a % b == c){
                return true;
            }
        }
        return false;
    }
}
