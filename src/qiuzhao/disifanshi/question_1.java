package qiuzhao.disifanshi;

import java.util.Scanner;

/**
 * Package: qiuzhao.disifanshi
 * Description： 第一题
 * Author: TingTing W
 * Date: Created in 2018/9/9 14:52
 */
public class question_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strA = scanner.nextLine();
        String strB = scanner.nextLine();
        char charsA[] = strA.toCharArray();
        char charsB[] = strB.toCharArray();
        String result = getMulti(charsA, charsB, charsA.length, charsB.length);
        System.out.println(result);

    }
    private static String getMulti(char charsA[], char charsB[], int lenA, int lenB){

        int[] numA = new int[lenA];
        int[] numB= new int[lenB];

        int result[] = new int[lenA + lenB];

        for(int i = 0; i < lenA;i++)
            numA[i] = charsA[i]-'0';
        for(int i = 0; i < lenB;i++)
            numB[i] = charsB[i]-'0';

        for(int i =0 ; i < lenA; i++){
            for(int j = 0; j < lenB; j++){
                result[i+j]+=numA[i]*numB[j];
            }
        }

        for(int i = result.length - 1; i > 0 ; i--){
            result[i-1] += result[i] / 10;
            result[i] = result[i] % 10;
        }
        StringBuffer buffer = new StringBuffer();
        int index = 0;
        for (index = 0; index < result.length; index++){
            if (result[index] != 0){
                break;
            }
        }
        for(; index < result.length - 1; index++){
            buffer.append(result[index]);
        }
        return buffer.toString();
    }
}
