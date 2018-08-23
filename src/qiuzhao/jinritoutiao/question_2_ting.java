package qiuzhao.jinritoutiao;

import java.util.*;

public class question_2_ting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList();
        scanner.nextLine();
        for (int i = 0; i < num; i++){
            String[] strs = scanner.nextLine().split(";");
            for (int j = 0; j < strs.length; j++){
                ArrayList<Integer> item = new ArrayList<>();
                item.add(Integer.parseInt(strs[j].split(",")[0]));
                item.add(Integer.parseInt(strs[j].split(",")[1]));
                list.add(item);
            }
        }

        //重写比较器
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                ArrayList<Integer> array1 = (ArrayList) o1;
                ArrayList<Integer> array2 = (ArrayList) o2;
                if (array1.get(0) > array2.get(0)){
                    return 1;
                }else if(array1.get(0) < array2.get(0)){
                    return -1;
                }else {
                        if (array1.get(1) > array2.get(1)){
                            return 1;
                        }else if (array1.get(1) < array2.get(1)){
                            return -1;
                        }else {
                            return 0;
                        }
                }
            }
        };
        list.sort(comparator);
        int startTemp = list.get(0).get(0);
        int endTemp = list.get(0).get(1);
        ArrayList<String> outs = new ArrayList<>();

        // 排序后，当后一个的start大于endTemp时，出现断点，输出
        for (ArrayList item :
                list) {
            if ((int)item.get(0) > endTemp) {
                outs.add(startTemp + "," + endTemp);
                startTemp = (int)item.get(0);
                endTemp = (int)item.get(1);
            }else {
                endTemp = endTemp > (int)item.get(1) ? endTemp : (int)item.get(1);
            }
        }
        outs.add(startTemp + "," + endTemp);
        for (int t = 0; t < outs.size() - 1; t++){
            System.out.print(outs.get(t) + ";");
        }
        System.out.println(outs.get(outs.size() - 1));
    }

}
