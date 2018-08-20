package qiuzhao.pinduoduo;

import java.util.Scanner;

public class question_2_ting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        if (str.length() <= 2){
            System.out.println(1);
            return;
        }
        int count = 0;
        for (int i = 1; i < str.length(); i++){
            count += getCount(str.substring(0, i)) * getCount(str.substring(i, str.length()));
        }
        System.out.println(count);

    }

    /**
     * 计算子串可能组成的数字个数
     * @param str 子串
     * @return 数字个数
     */
    private static int getCount(String str) {
        if (str.length() == 1){
            return 1;
        }
        // 可以形成的整数、小数数目
        int intNum;
        int floatNum;
        // 0结尾
        if (str.charAt(str.length() - 1) == '0'){
            // 0开头
            if (str.charAt(0) == '0'){
                intNum = 0;
                floatNum = 0;
            }else {
                intNum = 1;
                floatNum = 0;
            }
        }
        // 非0结尾
        else {
            // 非0开头
            if (str.charAt(0) == '0'){
                intNum = 0;
                floatNum = 1;
            }else {
                intNum = 1;
                floatNum = str.length() - 1;
            }
        }
        return intNum + floatNum;
    }
}
