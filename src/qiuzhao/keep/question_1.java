package qiuzhao.keep;

import java.util.Scanner;

/**
 * Package: qiuzhao.keep
 * Description： 第一题
 * Author: TingTing W
 * Date: Created in 2018/9/12 16:55
 */
public class question_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int k = scanner.nextInt();
        char[] chars = str.toCharArray();
        System.out.println(getReverse(chars, k));
    }
    private static String getReverse(char[] chars, int k){
        int index = 0;
        StringBuffer buffer = new StringBuffer();
        while (index < chars.length){
            if (index + 3 * k - 1 < chars.length){
                for (int i = index + k - 1; i >= index; i--){
                    buffer.append(chars[i]);
                }
                for (int i = index + k; i <= index + 3 * k - 1; i++){
                    buffer.append(chars[i]);
                }
            }else if (index + 2 * k - 1 < chars.length){
                for (int i = index + k - 1; i >= index; i--){
                    buffer.append(chars[i]);
                }
                for (int i = index + k; i < chars.length; i++){
                    buffer.append(chars[i]);
                }
            }else {
                for (int i = chars.length - 1; i >= index; i--){
                    buffer.append(chars[i]);
                }
            }
            index += 3 * k;
        }
        return buffer.toString();
    }

}















