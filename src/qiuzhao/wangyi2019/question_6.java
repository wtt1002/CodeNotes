package qiuzhao.wangyi2019;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Package: qiuzhao.wangyi2019
 * Description： 网易2019第六题
 * Author: TingTing W
 * Date: Created in 2018/8/18 15:16
 */
public class question_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int heapSum = scanner.nextInt();
        int maxStep = scanner.nextInt();
        int[] heaps = new int[heapSum + 1];
        ArrayList<int[]> steps = new ArrayList<>();
        for (int i = 1; i < heaps.length; i++){
            heaps[i] = scanner.nextInt();
        }

        int maxIndex;
        int minIndex;
        for (int realStep = 0; realStep < maxStep; realStep++) {
            int[] topAndDown = getTopDown(heaps);
            maxIndex = topAndDown[0];
            minIndex = topAndDown[1];
            if (heaps[maxIndex] == heaps[minIndex]){
                break;
            }
            heaps[maxIndex]--;
            heaps[minIndex]++;
            int[] temp = {maxIndex, minIndex};
            steps.add(temp);
        }
        int[] topAndDown = getTopDown(heaps);
        maxIndex = topAndDown[0];
        minIndex = topAndDown[1];
        System.out.println(heaps[maxIndex] - heaps[minIndex] + " " + steps.size());
        for (int[] step : steps) {
            System.out.println(step[0] + " " + step[1]);
        }
    }

    private static int[] getTopDown(int[] heaps) {
        int[] array = new int[2];
        int maxIndex = 1;
        int minIndex = 1;
        for (int i = 1; i < heaps.length; i++){
            if (heaps[i] > heaps[maxIndex]){
                maxIndex = i;
            }
            if (heaps[i] < heaps[minIndex]){
                minIndex = i;
            }
        }
        array[0] = maxIndex;
        array[1] = minIndex;
        return array;
    }
}
