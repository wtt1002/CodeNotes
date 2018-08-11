package qiuzhao.wangyi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class question_3_long {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int z = scanner.nextInt();
        int k = scanner.nextInt();
        StringBuffer stringBuffer = new StringBuffer();
        while (a != 0) {
            stringBuffer.append("a");
            a--;
        }
        while (z != 0) {
            stringBuffer.append("z");
            z--;
        }

        ArrayList<String> res = new ArrayList<String>();
        res = Result(stringBuffer.toString());
        System.out.print(res.get(k-1));
    }

    public static ArrayList<String> Result(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if(str == null || str.length() <= 0)
            return res;
        HashSet<String> set = new HashSet<String>(); //结果去重
        dfs(set, str.toCharArray(), 0);
        res.addAll(set);
        Collections.sort(res);
        return res;
    }

    public static void dfs(HashSet<String> set, char [] str, int k){
        if(k == str.length){
            set.add(new String(str));
            return ;
        }
        for(int i = 0; i < str.length; i ++){
            swap(i, k, str);
            dfs(set, str, k + 1);
            swap(i, k, str);
        }
    }

    public static void swap(int i, int j, char [] str){
        if(i != j){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }

}
