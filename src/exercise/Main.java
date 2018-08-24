package exercise;

import java.util.Scanner;

/**
 * Package: exercise
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/7/28 9:13
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employees = scanner.nextInt();
        int gifts = scanner.nextInt();
        int[] store = new int[gifts];
        for (int i = 0; i < gifts; i++){
            store[i] = scanner.nextInt();
        }
        int[] demand = new int[employees];
        for (int i = 0; i < employees; i++){
            double rate = 0;
            int giftNum = 1;
            for (int j = 0; j < gifts; j++){
                double newRate = scanner.nextDouble();
                if (newRate > rate){
                    rate = newRate;
                    giftNum = j;
                }
            }
            demand[i] = giftNum;
        }
        System.out.println(jobGifts(store, demand));
    }
    public static int matchStr(String strA, String strB){
        if (strA == null || strB == null || strA.length() > strB.length()){
            return 0;
        }
        int countOne = 0;
        int countTwo = 0;
        int diff = strB.length() - strA.length();
        for (int i = 0; i < strA.length(); i++){
            if (strA.charAt(i) != strB.charAt(i)){
                countOne++;
            }
        }
        for (int j = strA.length() - 1; j >= 0; j--){
            if (strA.charAt(j) != strB.charAt(j + diff)){
                countTwo++;
            }
        }
        return countOne < countTwo ? countOne : countTwo;
    }

    public static double jobGifts(int[] store, int[] demand){

        for (Integer i : store){
            System.out.print(i + " ");
        }
        System.out.println();
        for (Integer j : demand){
            System.out.print(j + " ");
        }
        return 1.0;
    }
}
