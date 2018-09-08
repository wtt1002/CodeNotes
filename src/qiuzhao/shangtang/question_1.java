package qiuzhao.shangtang;

import java.util.Scanner;

/**
 * Package: qiuzhao.shangtang
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/9/7 0007$ 下午 6:53$
 */
public class question_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int k = scanner.nextInt();
        int[] array = new int[len];
        int preMax = -100000;
        int preMin = 100000;
        for (int i = 0; i < len; i++){
            array[i] = scanner.nextInt();
            if (array[i] > preMax){
                preMax = array[i];
            }
            if (array[i] < preMin){
                preMin = array[i];
            }
        }
        if (len <= 0){
            return;
        }
        int preOutDiff = preMax - preMin;
        int max = -100000;
        int min = array[0] - k;
        int mid = array[0] - k;
        for (int i = 1; i < len; i++){
            double diff1 = getDiff(array[i] - k, mid);
            double diff2 = getDiff(array[i] + k, mid);
            if (diff1 < diff2){
                mid = (mid * i + array[i] - k)/(i + 1);
                if (array[i] - k > max){
                    max = array[i] - k;
                }
                if (array[i] - k < min){
                    min = array[i] - k;
                }
            }else if(diff1 > diff2) {
                mid = (mid * i + array[i] + k)/(i + 1);
                if (array[i] + k > max){
                    max = array[i] + k;
                }
                if (array[i] + k < min){
                    min = array[i] + k;
                }
            }else {
                if (i + 1 < len){
                    if (getDiff(array[i] - k,array[i + 1]) <= getDiff(array[i] + k, array[i + 1])){
                        mid = (mid * i + array[i] - k)/(i + 1);
                        if (array[i] - k > max){
                            max = array[i] - k;
                        }
                        if (array[i] - k < min){
                            min = array[i] - k;
                        }
                    }else {
                        mid = (mid * i + array[i] + k)/(i + 1);
                        if (array[i] + k > max){
                            max = array[i] + k;
                        }
                        if (array[i] + k < min){
                            min = array[i] + k;
                        }
                    }
                }else {
                    mid = (mid * i + array[i] - k)/(i + 1);
                    if (array[i] - k > max){
                        max = array[i] - k;
                    }
                    if (array[i] - k < min){
                        min = array[i] - k;
                    }
                }
            }

        }
        int outDiff1 = max - min;


        max = -100000;
        min = array[0] + k;
        mid = array[0] + k;
        for (int i = 1; i < len; i++){

            double diff1 = getDiff(array[i] - k, mid);
            double diff2 = getDiff(array[i] + k, mid);
            if (diff1 < diff2){
                mid = (mid * i + array[i] - k)/(i + 1);
                if (array[i] - k > max){
                    max = array[i] - k;
                }
                if (array[i] - k < min){
                    min = array[i] - k;
                }
            }else if(diff1 > diff2) {
                mid = (mid * i + array[i] + k)/(i + 1);
                if (array[i] + k > max){
                    max = array[i] + k;
                }
                if (array[i] + k < min){
                    min = array[i] + k;
                }
            }else {
                if (i + 1 < len){
                    if (getDiff(array[i] - k,array[i + 1]) <= getDiff(array[i] + k, array[i + 1])){
                        mid = (mid * i + array[i] - k)/(i + 1);
                        if (array[i] - k > max){
                            max = array[i] - k;
                        }
                        if (array[i] - k < min){
                            min = array[i] - k;
                        }
                    }else {
                        mid = (mid * i + array[i] + k)/(i + 1);
                        if (array[i] + k > max){
                            max = array[i] + k;
                        }
                        if (array[i] + k < min){
                            min = array[i] + k;
                        }
                    }
                }
                else {
                    mid = (mid * i + array[i] - k)/(i + 1);
                    if (array[i] - k > max){
                        max = array[i] - k;
                    }
                    if (array[i] - k < min){
                        min = array[i] - k;
                    }
                }
            }

        }
        int outDiff2 = max - min;
        System.out.println(getMin(preOutDiff, outDiff1, outDiff2));


    }
    private static double getDiff(double a, double b){
        return Math.abs(a - b);
    }
    private static int getMin(int a, int b, int c){
        int temp = a < b ? a : b;
        int outTemp = temp < c ? temp : c;
        return outTemp;
    }
}
