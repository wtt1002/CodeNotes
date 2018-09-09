package qiuzhao.disifanshi;

import java.util.Scanner;

/**
 * Package: qiuzhao.disifanshi
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/9/9 14:52
 */
public class question_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String result = longerStr(str);
        System.out.println(result);

    }
    private static String longerStr(String str){
        int n=str.length();
        boolean[][] pal=new boolean[n][n];
        String maxStr = "";
        int maxLen=0;
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if(str.charAt(i)==str.charAt(j) && (i-j < 2 || pal[j+1][i-1])){
                    pal[j][i]=true;
                    if (i - j + 1 > maxLen){
                        maxLen = i - j + 1;
                        maxStr = str.substring(j, i + 1);
                    }
                }
            }
        }
        return maxStr;
    }
}
