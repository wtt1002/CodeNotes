package qiuzhao.pinduoduo;

import java.util.ArrayList;
import java.util.Scanner;
public class question_3 {
    static int[][] mark = null;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayList<Integer> inList = getNum(input);
        int peopleNum = inList.get(0);
        int target = inList.get(1);
        if (peopleNum <= 0 || target > peopleNum - 1 || target < 0) {
            System.out.println(-1);
            return;
        }
        mark = new int[peopleNum][peopleNum];
        for (int i = 0; i < peopleNum; i++) {
            String str = scanner.nextLine();
            ArrayList<Integer> arrayList = getNum(str);
            for (int j = 0; j < arrayList.size(); j++) {
                mark[i][arrayList.get(j)] = 1;
            }
        }
        int[] intr = new int[peopleNum];
        for (int i = 0; i < mark.length; i++) {
            if (i != target && isNotFriend(i, target)) {
                int count = 0;
                for (int j = 0; j < mark.length; j++) {
                    count += mark[i][j] * mark[target][j];
                }
                intr[i] = count;
            }
        }

        int max = intr[0];
        int pos = 0;
        for (int i = 0; i < intr.length; i++) {
            if (intr[i] > max) {
                pos = i;
            }
        }
        System.out.println(pos);

    }
    private static boolean isNotFriend(int i, int target) {
        // TODO Auto-generated method stub
        if (mark[i][target] == 1) {
            return false;
        }
        return true;
    }
    public static ArrayList<Integer> getNum(String str){
        ArrayList<Integer> list = new ArrayList<>();
        String[] strs = null;
        if (str.length() != 0) {
            strs = str.split(" ");
        }
        for (int i = 0; strs != null &&i < strs.length; i++) {
            list.add(strs[i].charAt(0) - '0');
        }
        return list;
    }
}
