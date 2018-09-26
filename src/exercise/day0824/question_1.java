package exercise.day0824;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Package: exercise.day0824
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/8/24 20:22
 */
public class question_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int robotSum = scanner.nextInt();
        int taskSum = scanner.nextInt();
        ArrayList<ArrayList<Integer>> robots = new ArrayList<>();
        ArrayList<ArrayList<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < robotSum; i++){
            ArrayList<Integer> item = new ArrayList<>();
            item.add(scanner.nextInt());
            item.add(scanner.nextInt());
            robots.add(item);
        }
        for (int j = 0; j < taskSum; j++){
            ArrayList<Integer> item = new ArrayList<>();
            item.add(scanner.nextInt());
            item.add(scanner.nextInt());
            tasks.add(item);
        }
        Comparator<ArrayList<Integer>> comparator = new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (o1.get(0) > o2.get(0)){
                    return 1;
                }else if (o1.get(0) < o2.get(0)){
                    return -1;
                }else {
                    return o2.get(1).compareTo(o1.get(1));
                }
            }
        };
        // 排序
        robots.sort(comparator);
        tasks.sort(comparator);
        int total = 0;
        int count = 0;
        for (ArrayList robot : robots) {
            int flag = -1;
            for (int t = 0; t < tasks.size(); t++){
                if ((int)robot.get(0) >= tasks.get(t).get(0)
                        && (int)robot.get(1) >= tasks.get(t).get(1)){
                    total += tasks.get(t).get(0) * 200 + tasks.get(t).get(1) * 3;
                    flag = t;
                    count++;
                    break;
                }
            }
            tasks.remove(flag);
        }
        System.out.println(count + " " + total);
    }
}
