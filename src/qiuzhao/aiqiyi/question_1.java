package qiuzhao.aiqiyi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Package: qiuzhao.aiqiyi
 * Description： 第一题
 * Author: TingTing W
 * Date: Created in 2018/9/28 0028$ 下午 6:51$
 */
public class question_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        ArrayList<Map<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < num; i++){
            int boxSize = scanner.nextInt();
            if (list.size() == 0){
                Map<Integer, Integer> tMap = new HashMap<>();
                tMap.put(boxSize, 1);
                list.add(tMap);
            }else {
                boolean flag = true;
                for (int k = 0; k < list.size();){
                    if (list.get(k).containsKey(boxSize)){
                        k++;
                    }else {
                        list.get(k).put(boxSize, 1);
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    Map<Integer, Integer> tmap = new HashMap<>();
                    tmap.put(boxSize, 1);
                    list.add(tmap);
                }
            }
        }
        System.out.println(list.size());
    }
}
