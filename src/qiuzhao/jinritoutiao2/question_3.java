package qiuzhao.jinritoutiao2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 通过40%
 */
public class question_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < num; i++){
            int sum = Integer.parseInt(scanner.nextLine());
            ArrayList<String> strs = new ArrayList<>();
            for (int j = 0; j < sum; j++){
                String s = scanner.nextLine();
                strs.add(s);
            }
            if(isDouble(strs) == true){
                System.out.println("Yeah");
            }else {
                System.out.println("Sad");
            }
        }
    }

    private static boolean isDouble(ArrayList<String> strs) {
        for (int i = 0; i < strs.size(); i++){
            for (int j = i + 1; j < strs.size(); j++){
                if(isDoubleCore(strs.get(i), strs.get(j))){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isDoubleCore(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        if (isRightDouble(s1, s2) || isLeftDouble(s1, s2)){
            return true;
        }
        return false;
    }

    private static boolean isLeftDouble(String s1, String s2) {
        s1 = getReStr(s1);

        return isRightDouble(s1, s2);
    }

    private static String getReStr(String s1) {
        StringBuffer buffer = new StringBuffer();
        for (int i = s1.length() - 1; i >= 0; i--){
            buffer.append(s1.charAt(i));
        }
        return buffer.toString();
    }

    private static boolean isRightDouble(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++){
            if (s2.charAt(0) == s1.charAt(i)){
                if (s1.substring(i).equals(s2.substring(0, s1.length() - i)) && s1.substring(0, i).equals(s2.substring(s1.length() - i))){
                    return true;
                }
            }
        }
        return false;
    }
}
