package qiuzhao.pinduoduo;

import java.util.Scanner;

public class question_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int count = 0;
        int len = input.length();
        for(int i = 1; i < len; ++ i){
            String s1 = input.substring(0, i);
            String s2 = input.substring(i, len - i);
            count += ifInt(s1) * ifInt(s2) + ifInt(s1) * howManyFloat(s2) + ifInt(s2) * howManyFloat(s1) + howManyFloat(s2) * howManyFloat(s1);
            //cout << count << endl;
        }
        System.out.println(count);

    }

    /**
     * float 类型可能的组合
     * @param s 输入
     * @return 组合数
     */
    private static int howManyFloat(String s){
        int len = s.length();
        if (len == 0)
            return 0;
        if (len==0 && s.charAt(0) == '0')
            return 0;
        if(s.charAt(len - 1) == '0')
            return 0;
        if (s.charAt(0) == '0')
            return 1;
        return len - 1;

    }

    /**
     *  int 类型可能的组合
     * @param s 输入
     * @return 组合数
     */
    private static int ifInt(String s){
        int len = s.length();
        if(len == 0)
            return 0;
        if(len > 1 && s.charAt(0) == '0')
            return 0;
        return 1;
    }
}
