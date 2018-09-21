package qiuzhao.jinritoutiao4;

import java.util.Scanner;

/**
 * Package: qiuzhao.jinritoutiao4
 * Description： 第四题（暴力，过30%）
 * Author: TingTing W
 * Date: Created in 2018/9/20 0020$ 下午 6:43$
 */
public class question_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] ball = {0, n, m, k};
        int len = n + m + k;
        int[] array = new int[len];
        int index = 0;
        long count = 0;
        while(index >= 0){
            while(array[index] < 3){
                if(ball[array[index] + 1] > 0){
                    if(array[index] > 0)
                        ++ ball[array[index]];
                    ++ array[index];
                    -- ball[array[index]];
                }
                else if(array[index] < 2 && ball[array[index] + 2] > 0){
                    if(array[index] > 0)
                        ++ ball[array[index]];
                    array[index] += 2;
                    -- ball[array[index]];
                }
                else if(array[index] < 1 && ball[array[index] + 3] > 0){
                    if(array[index] > 0)
                        ++ ball[array[index]];
                    array[index] += 3;
                    -- ball[array[index]];
                }
                else
                    break;
                int state = judge(array, index);
                if(state == 0)
                    ++ index;
                else if(state == 1)
                    ++ count ;
                //cout << index << " " << array[index] << endl;
            }
            ++ ball[array[index]];
            array[index] = 0;
            -- index;

        }
        System.out.println(count);

    }
    private static int judge(int[] array, int n){
        int flag = 1;
        for(int i = 0; i < n; ++ i){
            if(array[i] == array[i + 1]){
                flag = 0;
                break;
            }
        }
        if(n == array.length - 1 && flag == 1)
            return 1;
        if(flag == 1)
            return 0;
        return -1;
    }

}
