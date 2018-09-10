package qiuzhao.jingdong;
import java.util.Scanner;
/**
 * Package: qiuzhao.jingdong
 * Description： 第二题
 * Author: TingTing W
 * Date: Created in 2018/9/9 18:34
 */
public class question_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] myGoods = new int[n][3];
        for (int i = 0; i < n; i++) {
            myGoods[i][0] = sc.nextInt();
            myGoods[i][1] = sc.nextInt();
            myGoods[i][2] = sc.nextInt();
        }
        System.out.println(coreFunction(myGoods, n));

    }
    private static int coreFunction(int[][] myGoods, int n){
        int count = 0;
        for (int i = 0; i < n; i++) {
            int one = myGoods[i][0];
            int two = myGoods[i][1];
            int three = myGoods[i][2];
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }
                if (one < myGoods[j][0] && two < myGoods[j][1] && three < myGoods[j][2]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}