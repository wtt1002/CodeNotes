package qiuzhao.jinritoutiao;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class question_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<String> input = new ArrayList<>();
        for(int i = 0; i<=count; i++){
            String tempStr = scanner.nextLine();
            input.add(tempStr);
        }
        input.remove(0);

        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String[] item = input.get(i).split(";");
            for (int j = 0; j < item.length; j++) {
                hashMap.put(Integer.parseInt(item[j].split(",")[0]), Integer.parseInt(item[j].split(",")[1]));
            }
        }

        List<Integer> starts = new ArrayList<>(hashMap.keySet());
        Comparator<Integer> comparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {

                return o1 > o2 ? 1 : -1;
            }
        };
        starts.sort(comparator);
        String result = "";
        int startTemp = starts.get(0);
        int endTemp = hashMap.get(startTemp);
        for (int i = 1; i < starts.size(); i++) {
            int start = starts.get(i);
            int end = hashMap.get(start);
            if (start <= endTemp) {
                if (end > endTemp) {
                    endTemp = end;
                }
            } else {
                result += startTemp + "," + endTemp + ";";
                startTemp = start;
                endTemp = end;
            }
        }
        result += startTemp + "," + endTemp;
        System.out.println(result);

    }

}
