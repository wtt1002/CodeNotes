package qiuzhao.bytedance2018;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Package: qiuzhao.bytedance2018
 * @Description: 2018字节跳动第一题
 * @Author: TingTing W
 * @Date: Created in 2018/8/27 下午 10:38
 */
public class question_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lenA = scanner.nextInt();
        int lenB = scanner.nextInt();
        Set<Integer> setA = new TreeSet<>();
        Set<Integer> setB = new TreeSet<>();
        for (int i = 0; i < lenA; i++){
            setA.add(scanner.nextInt());
        }
        for (int i = 0; i < lenB; i++){
            setB.add(scanner.nextInt());
        }
        int count = 0;
        while (true){
            double avgA = getAvg(setA);
            double avgB = getAvg(setB);
            int moveA = getMove(setA, avgA, avgB);
            int moveB = getMove(setB, avgB, avgA);
            if (moveA == -1 && moveB == -1){
                break;
            }else if (moveB == -1){
                setA.remove(moveA);
                setB.add(moveA);
                count++;
            }else if (moveA == -1){
                setB.remove(moveB);
                setA.add(moveB);
                count++;
            }else {
                System.out.println("不知道有没有这种情况，应该没有");
            }
        }
        System.out.println(count);
    }

    private static int getMove(Set<Integer> setA, double avgA, double avgB) {
        for (Integer i:
             setA) {
            if (i <= avgA && i > avgB){
                return i;
            }
        }
        return -1;
    }

    private static double getAvg(Set<Integer> setA) {
        double sum = 0.0;
        for (Integer i :
                setA) {
            sum += i;
        }
        return sum/setA.size();
    }
}
