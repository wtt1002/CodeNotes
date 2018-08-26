package qiuzhao.yuanfudao2019;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Package: qiuzhao.yuanfudao2019
 * @Description: TODO
 * @Author: TingTing W
 * @Date: Created in 2018/8/26 6:47
 */
public class question_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleSum = scanner.nextInt();
        int busValue = scanner.nextInt();
        ArrayList<ArrayList<Integer>> myList = new ArrayList<>();
        for (int i = 0; i < peopleSum;){
            ArrayList<Integer> item = new ArrayList<>();
            for (int j = 0; j < busValue && i < peopleSum; j++){
                item.add(scanner.nextInt());
                i++;
            }
            myList.add(item);
        }
        for (int k = myList.size() - 1; k > 0; k--){
            for (int m = 0; m < myList.get(k).size(); m++){
                System.out.print(myList.get(k).get(m) + " ");
            }
        }
        int len = myList.get(0).size();
        for (int k = 0; k < len - 1; k++){
            System.out.print(myList.get(0).get(k) + " ");
        }
        System.out.print(myList.get(0).get(len - 1));
    }
}
