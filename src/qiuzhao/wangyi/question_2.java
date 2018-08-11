package qiuzhao.wangyi;

import java.util.Scanner;

public class question_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int heapSum = scanner.nextInt();
        int[] heapArray = new int[heapSum + 1];
        for (int i = 1; i<= heapSum; i++){
            int num = scanner.nextInt();
            heapArray[i] = heapArray[i - 1] + num;
        }
        int querySum = scanner.nextInt();
        int[] queryArr = new int[querySum];
        for (int i = 0; i < querySum; i++){
            queryArr[i] = scanner.nextInt();
        }

        for (int i = 0; i < querySum; i++){
            int heapNum = getHeapNum(heapArray, queryArr[i]);
            System.out.println(heapNum);
        }
    }

    private static int getHeapNum(int[] heapArray, int i) {
        int start = 1;
        int end = heapArray.length - 1;
        if (i <= heapArray[1])return 1;
        if (i > heapArray[heapArray.length - 2])return heapArray.length - 1;
        int mid = start + (end - start)/2;
        while (start + 1 < end){
            mid = start + (end - start)/2;
            if (i <= heapArray[mid]){
                if (i > heapArray[mid - 1]){
                    return mid;
                }else {
                    end = mid;
                }
            }else {
                if (i < heapArray[mid + 1]){
                    return mid + 1;
                }else {
                    start = mid;
                }
            }
        }
        return mid;
    }


}
