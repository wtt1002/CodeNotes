package qiuzhao.wangyi2019;

import java.util.Scanner;

/**
 * Package: qiuzhao.wangyi2019
 * Description： 网易2019第三题
 * Author: TingTing W
 * Date: Created in 2018/8/18 10:12
 */
public class question_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int heapSum = scanner.nextInt();
        int[] heaps = new int[heapSum + 1];
        for (int i = 1; i < heapSum + 1; i++){
            heaps[i] = scanner.nextInt() + heaps[i - 1];
        }
        int querySum = scanner.nextInt();
        int[] querys = new int[querySum];
        for (int i = 0; i < querySum; i++){
            querys[i] = scanner.nextInt();
        }

        for (int i = 0; i < querySum; i++){
            int heap = getPosition(heaps, querys[i]);
            System.out.println(heap);
        }
    }

    private static int getPosition(int[] heaps, int query) {
        int start = 1;
        int end = heaps.length - 1;
        if (query <= heaps[1]) return 1;
        if (query > heaps[end - 1]) return end;
        int mid = start + (end - start) / 2;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (query <= heaps[mid]) {
                if (query > heaps[mid - 1]) {
                    return mid;
                } else {
                    end = mid;
                }
            } else {
                if (query <= heaps[mid + 1]) {
                    return mid + 1;
                } else {
                    start = mid;
                }
            }
        }
        return mid;
    }
}
