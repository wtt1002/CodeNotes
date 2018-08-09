package qiuzhao.wangyihuyu;

import java.util.Scanner;

public class question_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] passwords = new String[num];
        for (int i = 0; i < num; i++){
            passwords[i] = scanner.next();
        }
        boolean[] ans = new boolean[num];
        for (int i = 0; i < num; i++){
            ans[i] = ruleOne(passwords[i])&&ruleTwo(passwords[i])&&ruleThree(passwords[i])&&ruleFour(passwords[i])&&ruleFive(passwords[i]);
            if (ans[i] == true){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }
        for (int i = 0; i < num; i++){
            System.out.println("one:" + ruleOne(passwords[i]));
            System.out.println("two:" + ruleTwo(passwords[i]));
            System.out.println("three:" + ruleThree(passwords[i]));
            System.out.println("four:" + ruleFour(passwords[i]));
            System.out.println("five:" + ruleFive(passwords[i]));
            System.out.println("===========================================");
        }
    }

    private static boolean ruleFive(String password) {
        String regex=".*(password|admin|qwerty|hello|iloveyou|112233).*";  //正则表达式的regex
        if(password.matches(regex)){
            return false;
        }else{
            return true;
        }
    }

    private static boolean ruleFour(String password) {
        for (int i = 1; i <= password.length() - 2; i++) {
            if (password.charAt(i) * 2 == password.charAt(i - 1) + password.charAt(i + 1) && password.charAt(i) - password.charAt(i - 1) == 1){
                if (isAlpha(password.charAt(i - 1)) && isAlpha(password.charAt(i + 1))){
                    System.out.println("rule4 返回false");
                    return false;
                }
            }

        }
        return true;
    }

    private static boolean isAlpha(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'){
            return true;
        }else {
            System.out.println("c=============" + c);
            return false;
        }
    }

    private static boolean ruleThree(String password) {
        for (int i = 1; i <= password.length() - 2; i++){
            if (password.charAt(i) * 2 == password.charAt(i - 1) + password.charAt(i + 1)){
                if (password.charAt(i - 1) >= '0' && password.charAt(i - 1) <= '9' && password.charAt(i + 1) >= '0' && password.charAt(i + 1) <= '9'){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean ruleTwo(String password) {
        int[] mark = new int[256];
        for (int i = 0; i < password.length(); i++) {
            mark[password.charAt(i)]++;
        }
        // 数字
        int digtalSum = 0;
        for (int k = 48; k <= 57; k++) {
            digtalSum += mark[k];
        }
        if (digtalSum == 0) {
            System.out.println("没数字");
            return false;
        }
        // 大写
        int upperSum = 0;
        for (int k = 65; k <= 90; k++) {
            upperSum += mark[k];
        }
        if (upperSum == 0) {
            System.out.println("没大写字母");
            return false;
        }
        // 小写
        int lowerSum = 0;
        for (int k = 97; k <= 122; k++) {
            lowerSum += mark[k];
        }
        if (lowerSum == 0) {
            return false;
        }
        // 特殊字符
        if (digtalSum + upperSum + lowerSum < password.length()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean ruleOne(String password) {
        if (password.length() < 8 || password.length() > 16){
            return false;
        }else {
            return true;
        }

    }
}
