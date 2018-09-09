package qiuzhao.jinritoutiao3;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Package: qiuzhao.jinritoutiao3
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/9/9 9:32
 */
public class question_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int result = coreFunction(str);
        System.out.println(result);
    }

    private static int coreFunction(String str) {
        int[] preArr = new int[str.length()];
        char[] str2charArr = str.toCharArray();
        int max;
        Map<Character, Integer> charPosition = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            Integer lastPos = charPosition.get(str2charArr[i]);
            if(lastPos == null){
                preArr[i] = i == 0 ? 1 : preArr[i-1] + 1;
                charPosition.put(str2charArr[i], i);
            }
            else{
                int aPos = lastPos + 1;
                int unRep = preArr[i-1];
                int bPos = i - unRep;
                if(aPos >= bPos){
                    preArr[i] = i - aPos + 1;
                }
                else{
                    preArr[i] = i - bPos + 1;
                }
                charPosition.put(str2charArr[i], i);
            }
        }
        max = preArr[0];
        for(int i: preArr) if(i > max) max = i;
        return max;
    }

}
