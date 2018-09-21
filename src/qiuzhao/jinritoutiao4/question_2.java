package qiuzhao.jinritoutiao4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Package: qiuzhao.jinritoutiao4
 * Description： 第二题
 * Author: TingTing W
 * Date: Created in 2018/9/20 0020$ 下午 6:42$
 */
public class question_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        ArrayList<String> items = new ArrayList<>();
        for (int i = 0; i < num; i++){
            items.add(scanner.next());
        }
        for (int i = 0; i < num; i++){
            String str = items.get(i);
            for (int k = 1; k <= str.length(); k++){
                if(getSingle(items, str.substring(0, k)) == true){
                    System.out.println(str.substring(0, k));
                    break;
                }
            }
        }
    }
    private static boolean getSingle(ArrayList<String> items, String subStr){
        int flag = 0;
        int index = 0;
        while(flag < 2 && index < items.size()) {
            if (items.get(index).length() >= subStr.length()){
                if (items.get(index).substring(0, subStr.length()).equals(subStr)){
                    flag++;
                }
            }
            index++;
        }
        if (flag == 1)return true;
        return false;
    }
}
