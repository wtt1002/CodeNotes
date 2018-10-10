package qiuzhao.zhongxinyinhang;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: qiuzhao.zhongxinyinhang
 * Description： 1
 * Author: TingTing W
 * Date: Created in 2018/10/9 20:30
 */
public class question_2 {
    public static void main(String[] args) {

        System.out.println(code(2));
    }
    private static List<Integer> code(int n){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        if(n == 0)
            return list;
        int bit = 0;
        int temp = n;
        while(temp > 0){
            temp /= 2;
            ++ bit;
        }

        int[] s_t = new int[bit];
        int judge = 0;
        while(judge != n){
            for(int i = bit - 1; i >= 0; -- i){
                int[] s_now = s_t.clone();
                s_now[i] = (s_t[i] == 1? 0 : 1);
                temp = strToInt(s_now);
                if(!isfind(list, temp)){
                    judge = temp;
                    s_t = s_now;
                    list.add(judge);
                    break;
                }
            }
        }
        return list;
    }

    private static int strToInt(int[] s){
        int sum = 0;
        for(int i = 0; i < s.length; ++ i){
            sum = sum * 2 + s[i];
        }
        return sum;
    }

    private static boolean isfind(List<Integer> output, int temp){
        for(int i = 0; i < output.size(); ++ i){
            if(temp == output.get(i))
                return true;
        }
        return false;
    }
}
